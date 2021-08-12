package com.service.fuex.engineer.service;

import com.service.fuex.engineer.email.Down;
import com.service.fuex.engineer.email.EmailConfig;
import com.service.fuex.web.model.AccessCode;
import com.service.fuex.web.model.ChangePassword;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.AccessCodeRepository;
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
    private AccessCodeRepository accessCodeRepository;

    @Autowired
    private Down emailSending;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Override
    public CommonResponse<User> register(User userRequire){
        User checkingEmail = userRepository.checkingAbilityUser(userRequire.getEmail());
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
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        userRequire.setPassword(saltStr);
        var rambow = userRepository.save(userRequire);
        return commonResponseGenerator.successResponse(rambow);
    }

    @Override
    public CommonResponse<User> login(HttpServletRequest request) {
        String authorizationEmail = request.getHeader("email");
        String authorizationPassword = request.getHeader("password");
        if(authorizationEmail != null && authorizationPassword != null){
            User checkingEmail = userRepository.findByEmail(authorizationEmail, authorizationPassword);
            if (checkingEmail == null){
                return  commonResponseGenerator.failResponse( "EMAIL OR PASSWORD NOT FOUND");
            }
            return commonResponseGenerator.successResponse(checkingEmail);
            }
        return  commonResponseGenerator.failResponse("YOU MUST ACCESS ACCORDING TO THE PROCEDURE");
    }

    @Override
    public CommonResponse<TemporaryOtp> getUserByEmail(HttpServletRequest request)  throws TemplateException, MessagingException, IOException {
        String getUserByEmail = request.getHeader("email");
        if (getUserByEmail != null){
            User checkingEmail = userRepository.checkingAbilityUser(getUserByEmail);
            if (checkingEmail != null){
                return commonResponseGenerator.failResponse("EMAIL ALREADY EXIST");
            }
            Random random = new Random();
            int otpNumber = random.nextInt(1_000_000);
            TemporaryOtp createTemporaryOtp = new TemporaryOtp();
            createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
            createTemporaryOtp.setEmail(getUserByEmail);
            createTemporaryOtp.setVerified(false);
            createTemporaryOtp.setExpiredDate(new Date(System.currentTimeMillis() + 900_000));
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
    public CommonResponse<TemporaryOtp> checkingOtp(String otpNumber, String email){
        TemporaryOtp checkingOtp = temporaryOtpRepository.checkingOtp(otpNumber,email);
        if (checkingOtp == null) {
            return commonResponseGenerator.failResponse("OTP CODE or EMAIL NOT FOUND");
        }
        final var expiredDate = checkingOtp.getExpiredDate();
        final var newDate = new Date(System.currentTimeMillis());
        if (expiredDate.getTime() < newDate.getTime()) {
            return commonResponseGenerator.failResponse("YOUR CODE HAS EXPIRED");
        }
        checkingOtp.setVerified(true);
        final var addTimes = new Date(checkingOtp.getExpiredDate().getTime() + 900_000);
        checkingOtp.setExpiredDate(addTimes);
        return commonResponseGenerator.successResponse(temporaryOtpRepository.save(checkingOtp));
    }

    @Override
    public CommonResponse<TemporaryOtp> requestChangePassword(ChangePassword changePassword) {
            final var checkingOtp = accessCodeRepository.sendOtp(changePassword.getAccessCode());
            if (checkingOtp == null) {
                return commonResponseGenerator.failResponse("ACCESS CODE NOT FOUND");
            }
            final var expiredDate = checkingOtp.getExpiredDate();
            final var newDate = new Date(System.currentTimeMillis());
            if (expiredDate.getTime() < newDate.getTime()) {
                return commonResponseGenerator.failResponse("ACCESS CODE HAS EXPIRED");
            }
            if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
                var newPassword = userRepository.checkingAbilityUser(checkingOtp.getEmail());
                newPassword.setPassword(changePassword.getNewPassword());
                newPassword.setUpdateAt(new Date(System.currentTimeMillis()));
                userRepository.save(newPassword);
                return commonResponseGenerator.successResponse(newPassword);
            }
               return commonResponseGenerator.failResponse("PASSWORD CONFIRMATION MUST SAME");
    }

    @Override
    public Object requestSendChangePassword(HttpServletRequest request) throws TemplateException, MessagingException, IOException {
        String email = request.getHeader("email");
        if (email != null) {
            var checkigUser = userRepository.checkingAbilityUser(email);
            if (checkigUser == null) {
                return commonResponseGenerator.failResponse("EMAIL NOOT FOUND");
            }
            Random random = new Random();
            int access = random.nextInt(1_000_000);
            AccessCode annotation = new AccessCode();
            annotation.setAccessCode(String.valueOf(access));
            annotation.setEmail(checkigUser.getEmail());
            annotation.setExpiredDate(new Date(System.currentTimeMillis() + 900_000));
            var kembarAtauTidak = accessCodeRepository.checkigUser(email);
            if (kembarAtauTidak != null) {
                accessCodeRepository.deleteById(kembarAtauTidak.getId());
            }
            var isSuccess = accessCodeRepository.save(annotation);
            Map<String, Object> model = new HashMap<>();
            model.put("username",  checkigUser.getUsername());
            model.put("otp", isSuccess.getAccessCode());
            model.put("date", String.valueOf(isSuccess.getExpiredDate()));
            emailSending.sendEmailReq(email, model);
            return  checkigUser;
        }
        return commonResponseGenerator.failResponse("HEADER NOT VALID");
    }
}
