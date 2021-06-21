package com.service.fuex.engineer.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;

public interface ValidateService {
    User register(User userRequire) throws ResourceNotFoundExceotion;
}
