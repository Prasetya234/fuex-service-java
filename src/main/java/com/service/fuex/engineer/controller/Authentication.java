package com.service.fuex.engineer.controller;

import com.service.fuex.engineer.service.ValidateImpl;
import com.service.fuex.web.dto.TemporaryOtpDTO;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import freemarker.template.TemplateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
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
    public CommonResponse<User> registerUser(@RequestBody @Valid User userDTORequire){
        try {
            return validateService.register(userDTORequire);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage() + "anjay");
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
    public Object getUserByEmail(HttpServletRequest request) throws TemplateException, MessagingException, IOException {
        try {
            return validateService.getUserByEmail(request);
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/login/checking-otp", method = RequestMethod.GET)
    public CommonResponse<TemporaryOtpDTO> checkingOtp(@RequestParam(name = "otpNumber") String otpNumber,@RequestParam(name = "email") String email) throws ResourceNotFoundExceotion{
        return commonResponseGenerator.successResponse(validateService.checkingOtp(otpNumber,email));
    }
}
