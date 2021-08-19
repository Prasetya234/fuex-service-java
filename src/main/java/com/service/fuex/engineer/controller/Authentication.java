package com.service.fuex.engineer.controller;

import com.service.fuex.engineer.service.ValidateImpl;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.ChangePassword;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Api(value = "Authentication", description = "REST API for Login & Register")
@RestController
public class Authentication {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ValidateImpl validateService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse<User> registerUser(@RequestBody @Valid User userDTORequire){
        try {
            return validateService.register(userDTORequire);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request) throws TemplateException, MessagingException, IOException {
        try {
            return validateService.login(request);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/checking-avalibility-user", method = RequestMethod.GET)
    public Object getUserByEmail(HttpServletRequest request)throws TemplateException, MessagingException, IOException {
        try {
            return validateService.getUserByEmail(request);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/checking-otp", method = RequestMethod.GET)
    public CommonResponse<TemporaryOtp> checkingOtp(@RequestParam(name = "otp") String otpNumber, @RequestParam(name = "email") String email) throws ResourceNotFoundExceotion{
        try {
            return validateService.checkingOtp(otpNumber, email);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public CommonResponse<TemporaryOtp> changePasswordUpdate(@RequestBody @Valid ChangePassword changePassword) {
        try {
            return validateService.requestChangePassword(changePassword);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
