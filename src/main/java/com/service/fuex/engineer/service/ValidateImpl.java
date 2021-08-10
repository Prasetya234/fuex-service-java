package com.service.fuex.engineer.service;

import com.service.fuex.engineer.email.EmailConfig;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.TemporaryOtpRepository;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserTypeRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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
    private TemporaryOtpRepository temporaryOtpRepository;

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
        var hihi = userTypeRepository.findById(1L).get();
        if (hihi == null) {
            return  commonResponseGenerator.failResponse("USER TYPE ID NOT FOUND");
        }
        userRequire.setUserTypeId(hihi);
        var rambow = userRepository.save(userRequire);
        return commonResponseGenerator.successResponse(rambow);
    }

    @Override
    public CommonResponse<User> login(HttpServletRequest request) {
        String authorizationEmail = request.getHeader("email");
        String email;
        if(authorizationEmail != null){
            email = authorizationEmail;
                User checkingEmail = userRepository.findByEmail(email);
                if (checkingEmail == null){
                    return  commonResponseGenerator.failResponse( "YOUR EMAIL IS NOT REGISTERED");
                }
            return commonResponseGenerator.successResponse(checkingEmail);
            }
        return  commonResponseGenerator.failResponse("YOU MUST ACCESS ACCORDING TO THE PROCEDURE");
    }

    @Override
    public CommonResponse<TemporaryOtp> getUserByEmail(HttpServletRequest request)  throws TemplateException, MessagingException, IOException {
        String getUserByEmail = request.getHeader("email");
        if (getUserByEmail != null){
            User checkingEmail = userRepository.findByEmail(getUserByEmail);
            if (checkingEmail != null){
                return commonResponseGenerator.responseEmailNotFound("EMAIL ALREADY EXIST");
            }
            Random random = new Random();
            int otpNumber = random.nextInt(1_000_000);
            TemporaryOtp createTemporaryOtp = new TemporaryOtp();
            createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
            createTemporaryOtp.setEmail(getUserByEmail);
            createTemporaryOtp.setVerified(false);
            createTemporaryOtp.setExpiredDate(new Date(System.currentTimeMillis() + 900000));
            var checkingUserOtp = temporaryOtpRepository.findByEmail(getUserByEmail);
            if (checkingUserOtp != null) {
                temporaryOtpRepository.deleteById(checkingUserOtp.getOtpId());
            }
            var end = temporaryOtpRepository.save(createTemporaryOtp);
            Map<String, Object> model = new HashMap<>();
            model.put("username",  getUserByEmail);
            model.put("otp", end.getOtpNumber());
            emailConfig.sendEmail(getUserByEmail, model);
            return commonResponseGenerator.successResponse(end);
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
