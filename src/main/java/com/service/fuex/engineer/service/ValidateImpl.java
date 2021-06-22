package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserStatusRepository;
import com.service.fuex.web.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ValidateImpl implements ValidateService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;

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
    public Object login(HttpServletRequest request) throws ResourceNotFoundExceotion {
        String authorizationMobilePhoneNumber = request.getHeader("mobilePhoneNumber");

        String mobilePhoneNumber;

        if(authorizationMobilePhoneNumber != null){
            mobilePhoneNumber = authorizationMobilePhoneNumber;

            User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(mobilePhoneNumber);
            if (checkingMobilePhoneNumber == null){
                throw new ResourceNotFoundExceotion("NUMBER PHONE NOT FOUND");
            }
            return checkingMobilePhoneNumber;
        }
        throw new ResourceNotFoundExceotion("NOT VALIDATED");
    }

    @Override
    public Object getUserByMobilePhoneNumber(HttpServletRequest request) throws ResourceNotFoundExceotion {
        String getUserByMobilePhoneNumberFromHeader = request.getHeader("mobilePhoneNumber");

        String mobilePhoneNumber;

        if (getUserByMobilePhoneNumberFromHeader != null){
            mobilePhoneNumber = getUserByMobilePhoneNumberFromHeader;

            User checkingMobilePhoneNumber = userRepository.findByMobilePhoneNumber(mobilePhoneNumber);
            if (checkingMobilePhoneNumber == null){
                throw new ResourceNotFoundExceotion("NUMBER PHONE NOT FOUND");
            }
            return checkingMobilePhoneNumber;
        }
        throw new ResourceNotFoundExceotion("NOT VALIDATED");
    }
}
