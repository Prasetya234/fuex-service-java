package com.service.fuex.engineer.service;

import com.service.fuex.engineer.email.EmailConfig;
import com.service.fuex.engineer.email.ProfileUserEmail;
import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.ChangePassword;
import com.service.fuex.web.model.ChangePasswordRequest;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.ChangePasswordRequestRepository;
import com.service.fuex.web.repository.TemporaryOtpRepository;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserTypeRepository;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
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
    private ProfileUserEmail userSendEmail;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ChangePasswordRequestRepository changePasswordRequestRepository;

    @Override
    public CommonResponse<UserDTO> register(User userRequire) throws TemplateException, MessagingException, IOException {
        User checkingEmail = userRepository.checkingAbilityUser(userRequire.getEmail());
        if (checkingEmail != null) {
            return commonResponseGenerator.failResponse( "EMAIL ALREADY EXIST");
        }
        User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(userRequire.getMobilePhoneNumber());
        if (checkingMobilePhoneNumber != null) {
            return commonResponseGenerator.failResponse("NUMBER PHONE ALREADY EXIST");
        }
        userRequire.setUserType(String.valueOf(1));
        var hihi = userTypeRepository.findById(Long.valueOf(userRequire.getUserType())).get();
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
        Map<String, Object> model = new HashMap<>();
        model.put("username",  rambow.getUsername());
        model.put("email",  String.valueOf(rambow.getEmail()));
        model.put("password",  rambow.getPassword());
        userSendEmail.sendEmailUser(rambow.getEmail(), model);
        return commonResponseGenerator.successResponse(rambow);
    }

    @Override
    public User login(String email, String password) throws ResourceNotFoundExceotion {
        if(email != null && password != null){
            User checkingEmail = userRepository.findByEmail(email, password);
            if (checkingEmail == null){
                throw new ResourceNotFoundExceotion("EMAIL OR PASSWORD NOT FOUND");
            }
            return checkingEmail;
            }
        throw new ResourceNotFoundExceotion("YOU MUST ACCESS ACCORDING TO THE PROCEDURE");
    }

    @Override
    public CommonResponse<TemporaryOtp> getUserByEmail(String email)  throws TemplateException, MessagingException, IOException {
        try {
            if (email != null) {
                User checkingEmail = userRepository.checkingAbilityUser(email);
                if (checkingEmail != null) {
                    return commonResponseGenerator.failResponse("EMAIL ALREADY EXIST");
                }
                Random random = new Random();
                int otpNumber = random.nextInt(1_000_000);
                TemporaryOtp createTemporaryOtp = new TemporaryOtp();
                createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
                createTemporaryOtp.setEmail(email);
                createTemporaryOtp.setVerified(false);
                createTemporaryOtp.setExpiredDate(new Date(System.currentTimeMillis() + 900_000));
                var checkingUserOtp = temporaryOtpRepository.findByEmail(email);
                if (checkingUserOtp != null) {
                    temporaryOtpRepository.deleteById(checkingUserOtp.getOtpId());
                }
                var end = temporaryOtpRepository.save(createTemporaryOtp);
                Map<String, Object> model = new HashMap<>();
                model.put("username", email);
                model.put("otp", end.getOtpNumber());
                emailConfig.sendEmail(email, model);
                return commonResponseGenerator.successResponse(end);
            }
            return commonResponseGenerator.failResponse("NOT VALIDATED");
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
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
    public ChangePasswordRequest changePasswordRequest(String email) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException {
        var MPA02 = userRepository.checkingAbilityUser(email);
        if (MPA02 == null) {
            throw new ResourceNotFoundExceotion("EMAIL NOT FOUND");
        }
        var AIDSO02 = changePasswordRequestRepository.findByEmail(email);
        if (AIDSO02 != null){
            changePasswordRequestRepository.deleteById(AIDSO02.getId());
        }
        Random random = new Random();
        int code = random.nextInt(1_000_000);
        ChangePasswordRequest request = new ChangePasswordRequest();
        request.setCode(String.valueOf(code));
        request.setEmail(email);
        request.setAlreadyUsed(false);
        var sss=  changePasswordRequestRepository.save(request);
        Map<String, Object> model = new HashMap<>();
        model.put("yayay", sss.getCode());
        emailConfig.sendEmailRequestPassword(email, model);
        return request;
    }

    @Override
    public ChangePasswordRequest checkingCode(String code) throws ResourceNotFoundExceotion {
        var MAI03 = changePasswordRequestRepository.findByCode(code);
        if (MAI03 == null) {
            throw new ResourceNotFoundExceotion("ACCESS CODE NOT FOUND");
        }
        MAI03.setAlreadyUsed(true);
        return changePasswordRequestRepository.save(MAI03);
    }

    @Override
    public Object changePasswordUpdate(ChangePassword changePassword) {
        try {
            final var checkingOtp = changePasswordRequestRepository.findByCode(changePassword.getCode());
            if (checkingOtp == null) {
                return commonResponseGenerator.failResponse("ACCESS CODE NOT FOUND");
            }
            if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
                var newPassword = userRepository.checkingAbilityUser(checkingOtp.getEmail());
                newPassword.setPassword(changePassword.getNewPassword());
                newPassword.setUpdateAt(new Date(System.currentTimeMillis()));
                var OASDO21= userRepository.save(newPassword);
                Map<String, Object> model = new HashMap<>();
                model.put("username",  OASDO21.getUsername());
                model.put("email",  String.valueOf(checkingOtp.getEmail()));
                model.put("password",  changePassword.getNewPassword());
                userSendEmail.sendEmailUser(checkingOtp.getEmail(), model);
                return OASDO21;
            }
            return commonResponseGenerator.failResponse("PASSWORD CONFIRMATION MUST SAME");
        }catch(Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

}
