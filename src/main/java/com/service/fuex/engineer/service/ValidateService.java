package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ValidateService {
    Object register(User userRequire) throws ResourceNotFoundExceotion;

    Object login(HttpServletRequest request, TemporaryOtp createTemporaryOtp) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException;

    Object getUserByEmail(HttpServletRequest request) throws ResourceNotFoundExceotion;

    TemporaryOtp checkingOtp(String otpNumber,String email) throws ResourceNotFoundExceotion;
}
