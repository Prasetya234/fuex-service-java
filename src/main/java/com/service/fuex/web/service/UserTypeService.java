package com.service.fuex.web.service;

import com.service.fuex.web.model.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> getAll();

    UserType createUserType(UserType userTypeRequire);
}
