package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;

import javax.servlet.http.HttpServletRequest;

public interface ValidateService {
    User register(User userRequire) throws ResourceNotFoundExceotion;

    Object login(HttpServletRequest request) throws ResourceNotFoundExceotion;

    Object getUserByMobilePhoneNumber(HttpServletRequest request) throws ResourceNotFoundExceotion;
}
