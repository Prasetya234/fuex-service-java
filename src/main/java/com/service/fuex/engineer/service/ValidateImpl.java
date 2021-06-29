package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.TemporaryOtpRepository;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserStatusRepository;
import com.service.fuex.web.repository.UserTypeRepository;
import org.aspectj.bridge.IMessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

//    private Object TemporaryOtp;

    @Override
    public User register(User userRequire) throws ResourceNotFoundExceotion {
        User checkingEmail = userRepository.findByEmail(userRequire.getEmail());
        if (checkingEmail != null) {
            throw new ResourceNotFoundExceotion("EMAIL ALREADY EXIST");
        }
        User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(userRequire.getMobilePhoneNumber());
        if (checkingMobilePhoneNumber != null) {
            throw new ResourceNotFoundExceotion("NUMBER PHONE ALREADY EXIST");
        }
        userStatusRepository.findById(Long.valueOf(userRequire.getUserStatus()))
                .map(userStatus -> {
                    userRequire.setUserStatusId(userStatus);
                    return userRequire;
                }).orElseThrow(() -> new ResourceNotFoundExceotion("USER STATUS ID NOT FOUND"));
        userTypeRepository.findById(Long.valueOf(userRequire.getUserType()))
                .map(userType -> {
                    userRequire.setUserTypeId(userType);
                    return userRequire;
                }).orElseThrow(() -> new ResourceNotFoundExceotion("USER TYPE ID NOT FOUND"));
        return userRepository.save(userRequire);
    }


    @Override
    public Object login(HttpServletRequest request,TemporaryOtp createTemporaryOtp) throws ResourceNotFoundExceotion {
        String authorizationEmail = request.getHeader("email");

        String email;

        if(authorizationEmail != null){
            email = authorizationEmail;

            User checkingEmail = userRepository.findByEmail(email);
                if (checkingEmail == null){
                    throw new ResourceNotFoundExceotion("EMAIL NOT FOUND");
                }
                Random random = new Random();
                int otpNumber = 100000 + random.nextInt(900000);
                createTemporaryOtp.setOtpNumber(String.valueOf(otpNumber));
                createTemporaryOtp.setEmail(checkingEmail.getEmail());
                createTemporaryOtp.setVerified(false);
                TemporaryOtp save = temporaryOtpRepository.save(createTemporaryOtp);
                return save;
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
                throw new ResourceNotFoundExceotion("EMAIL NOT FOUND");
            }
            return checkingEmail;
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
