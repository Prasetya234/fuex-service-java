package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ValidateService {
    Object register(User userRequire) throws ResourceNotFoundExceotion;

    CommonResponse<User> login(HttpServletRequest request) ;

    CommonResponse<TemporaryOtp> getUserByEmail(HttpServletRequest request) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException;

    TemporaryOtp checkingOtp(String otpNumber,String email) throws ResourceNotFoundExceotion;
}
