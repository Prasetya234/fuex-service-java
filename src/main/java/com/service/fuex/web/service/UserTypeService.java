package com.service.fuex.web.service;

import com.service.fuex.web.model.UserType;

import java.util.List;
import java.util.Map;

public interface UserTypeService {
    List<UserType> getAll();

    UserType createUserType(UserType userTypeRequire);

    UserType updateUserType(Long userId, UserType userType);

    Map<String, Boolean> deleteUsertype(Long userStatusId);
}
