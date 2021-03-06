package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.ChangePassword;
import com.service.fuex.web.model.ChangePasswordRequest;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ValidateService {
    Object register(User userRequire) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException;

    User login(String email, String password) throws ResourceNotFoundExceotion;

    CommonResponse<TemporaryOtp> getUserByEmail(String email) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException;

    CommonResponse<TemporaryOtp> checkingOtp(String otpNumber,String email);

    ChangePasswordRequest changePasswordRequest(String email) throws ResourceNotFoundExceotion, TemplateException, MessagingException, IOException;

    ChangePasswordRequest checkingCode(String code) throws ResourceNotFoundExceotion;

    Object changePasswordUpdate(ChangePassword changePassword);
}
