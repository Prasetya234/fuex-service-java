package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;

import javax.servlet.http.HttpServletRequest;

public interface ValidateService {
    Object register(User userRequire) throws ResourceNotFoundExceotion;

    Object login(HttpServletRequest request, TemporaryOtp createTemporaryOtp) throws ResourceNotFoundExceotion;

    Object getUserByEmail(HttpServletRequest request) throws ResourceNotFoundExceotion;

    TemporaryOtp checkingOtp(String otpNumber,String email) throws ResourceNotFoundExceotion;
}
