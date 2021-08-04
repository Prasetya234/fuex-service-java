package com.service.fuex.engineer.service;

import com.service.fuex.engineer.email.EmailConfig;
import com.service.fuex.engineer.email.EmailRegister;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.TemporaryOtpRepository;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserStatusRepository;
import com.service.fuex.web.repository.UserTypeRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

@Service
public class ValidateImpl implements ValidateService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private TemporaryOtpRepository temporaryOtpRepository;

    @Autowired
    private EmailRegister emailRegister;

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public CommonResponse<User> register(User userRequire){
        User checkingEmail = userRepository.findByEmail(userRequire.getEmail());
        if (checkingEmail != null) {
            return commonResponseGenerator.failResponse( "Error" ,"EMAIL ALREADY EXIST");
        }
        User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(userRequire.getMobilePhoneNumber());
        if (checkingMobilePhoneNumber != null) {
            return commonResponseGenerator.failResponse("Error","NUMBER PHONE ALREADY EXIST");
        }
        var idn =  userStatusRepository.findById(1L).get();
        if (idn == null) {
            return commonResponseGenerator.failResponse("Error", "USER STATUS ID NOT FOUND");
        }
        userRequire.setUserStatusId(idn);
        var hihi = userTypeRepository.findById(1L).get();
        if (hihi == null) {
            return  commonResponseGenerator.failResponse("Error", "USER TYPE ID NOT FOUND");
        }
        userRequire.setUserTypeId(hihi);
        try {
            emailRegister.sendEmail(userRequire.getEmail());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse("Error", e.getMessage());
        }
        return commonResponseGenerator.successResponse(userRepository.save(userRequire));
    }

    @Override
    public Object login(HttpServletRequest request,TemporaryOtp createTemporaryOtp) throws ResourceNotFoundExceotion {
        String authorizationEmail = request.getHeader("email");

        String email;

        if(authorizationEmail != null){
            email = authorizationEmail;

                User checkingEmail = userRepository.findByEmail(email);
                if (checkingEmail == null){
                    throw new ResourceNotFoundExceotion("EMAIL NOT AVAILABLE");
                }
                Random random = new Random();
                int otpNumber = 100000 + random.nextInt(900000);
                createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
                createTemporaryOtp.setEmail(checkingEmail.getEmail());
                createTemporaryOtp.setVerified(false);
                var checkingUserOtp = temporaryOtpRepository.findByEmail(email);
                emailConfig.sendEmail(checkingEmail.getEmail());
                if (checkingUserOtp != null) {
                    temporaryOtpRepository.deleteById(checkingUserOtp.getOtpId());
                    return temporaryOtpRepository.save(createTemporaryOtp);
                }
                return temporaryOtpRepository.save(createTemporaryOtp);
            }
        throw new ResourceNotFoundExceotion("NOT VALIDATED");
    }

    @Override
    public Object getUserByEmail(HttpServletRequest request) throws ResourceNotFoundExceotion {
        String getUserByEmail = request.getHeader("email");

        String email;

        if (getUserByEmail != null){
            email = getUserByEmail;
            User checkingEmail = userRepository.findByEmail(email);
            if (checkingEmail == null){
                return commonResponseGenerator.responseEmailNotFound("EMAIL NOT FOUND", new Date());
            }
            return commonResponseGenerator.successResponse(checkingEmail);
        }
        throw new ResourceNotFoundExceotion("NOT VALIDATED");
    }

    @Override
    public TemporaryOtp checkingOtp(String otpNumber, String email) throws ResourceNotFoundExceotion {
        TemporaryOtp checkingOtp = temporaryOtpRepository.checkingOtp(otpNumber,email);
        if (checkingOtp == null) {
            throw new ResourceNotFoundExceotion("KODE OTP or EMAIL NOT FOUND");
        }
        checkingOtp.setVerified(true);
        return temporaryOtpRepository.save(checkingOtp);
    }
}
