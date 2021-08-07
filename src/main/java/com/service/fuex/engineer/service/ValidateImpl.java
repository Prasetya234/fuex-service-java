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
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
            return commonResponseGenerator.failResponse( "EMAIL ALREADY EXIST");
        }
        User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(userRequire.getMobilePhoneNumber());
        if (checkingMobilePhoneNumber != null) {
            return commonResponseGenerator.failResponse("NUMBER PHONE ALREADY EXIST");
        }
        var idn =  userStatusRepository.findById(1L).get();
        if (idn == null) {
            return commonResponseGenerator.failResponse("USER STATUS ID NOT FOUND");
        }
        userRequire.setUserStatusId(idn);
        var hihi = userTypeRepository.findById(1L).get();
        if (hihi == null) {
            return  commonResponseGenerator.failResponse("USER TYPE ID NOT FOUND");
        }
        userRequire.setUserTypeId(hihi);
        var rambow = userRepository.save(userRequire);
        try {
            Map<String, Object> model = new HashMap<>();
            model.put("username",  userRequire.getUsername());
            model.put("id", rambow.getUserId());
            emailRegister.sendEmail(userRequire.getEmail(), model);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse( e.getMessage());
        }
        return commonResponseGenerator.successResponse(rambow);
    }

    @Override
    public CommonResponse<TemporaryOtp> login(HttpServletRequest request, TemporaryOtp createTemporaryOtp) throws TemplateException, MessagingException, IOException {
        String authorizationEmail = request.getHeader("email");
        String email;
        if(authorizationEmail != null){
            email = authorizationEmail;
                User checkingEmail = userRepository.findByEmail(email);
                if (checkingEmail == null){
                    return  commonResponseGenerator.failResponse( "YOUR EMAIL IS NOT REGISTERED");
                }
                if (checkingEmail.getUserStatusId().getUserStatusId().equals(1L)) {
                    return commonResponseGenerator.failResponse( "YOUR ACCOUNT IS NOT ACTIVE");
                }
            Random random = new Random();
            int otpNumber = 100000 + random.nextInt(900000);
            createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
            createTemporaryOtp.setEmail(checkingEmail.getEmail());
            createTemporaryOtp.setVerified(false);
            var checkingUserOtp = temporaryOtpRepository.findByEmail(email);
            if (checkingUserOtp != null) {
                temporaryOtpRepository.deleteById(checkingUserOtp.getOtpId());
            }
            var end = temporaryOtpRepository.save(createTemporaryOtp);
            Map<String, Object> model = new HashMap<>();
            model.put("username",  checkingEmail.getUsername());
            model.put("otp", end.getOtpNumber());
            emailConfig.sendEmail(checkingEmail.getEmail(), model);
            return commonResponseGenerator.successResponse(end);
            }
        return  commonResponseGenerator.failResponse("YOU MUST ACCESS ACCORDING TO THE PROCEDURE");
    }
    @Override
    public Object getUserByEmail(HttpServletRequest request) {
        String getUserByEmail = request.getHeader("email");
        String email;
        if (getUserByEmail != null){
            email = getUserByEmail;
            User checkingEmail = userRepository.findByEmail(email);
            if (checkingEmail == null){
                return commonResponseGenerator.responseEmailNotFound("EMAIL NOT FOUND");
            }
            return commonResponseGenerator.successResponse(checkingEmail);
        }
        return commonResponseGenerator.failResponse("NOT VALIDATED");
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
