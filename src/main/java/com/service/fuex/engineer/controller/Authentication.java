package com.service.fuex.engineer.controller;

import com.service.fuex.engineer.service.ValidateImpl;
import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.ChangePassword;
import com.service.fuex.web.model.ChangePasswordRequest;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import freemarker.template.TemplateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class Authentication {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ValidateImpl validateService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTORequire){
        try {
            User user = modelMapper.map(userDTORequire, User.class);
            return validateService.register(user);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResponse<UserDTO> login(@RequestHeader(value = "email") String email, @RequestHeader(value = "password") String password) throws TemplateException, MessagingException, IOException {
        try {
            return commonResponseGenerator.successResponse(validateService.login(email, password));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/checking-avalibility-user", method = RequestMethod.GET)
    public CommonResponse<TemporaryOtp> getUserByEmail(@RequestHeader(value = "email") String email) throws TemplateException, MessagingException, IOException {
        return validateService.getUserByEmail(email);
    }

    @RequestMapping(value = "/checking-otp", method = RequestMethod.GET)
    public CommonResponse<TemporaryOtp> checkingOtp(@RequestParam(name = "otp") String otpNumber, @RequestParam(name = "email") String email) throws ResourceNotFoundExceotion{
        try {
            return validateService.checkingOtp(otpNumber, email);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password/request", method = RequestMethod.GET)
    public CommonResponse<ChangePasswordRequest> changePasswordRequest(@RequestHeader(value = "email") String email) {
        try {
            return commonResponseGenerator.successResponse(validateService.changePasswordRequest(email));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password/valid-code", method = RequestMethod.GET)
    public CommonResponse<ChangePasswordRequest> valid(@RequestHeader(value = "code") String code) {
        try {
            return commonResponseGenerator.successResponse(validateService.checkingCode(code));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public CommonResponse<User> changePasswordUpdate(@RequestBody @Valid ChangePassword changePassword) {
        try {
            return commonResponseGenerator.successResponse(validateService.changePasswordUpdate(changePassword));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
