package com.service.fuex.web.service;

import com.service.fuex.web.model.UserStatus;

import java.util.List;
import java.util.Map;

public interface UserStatusService {
    UserStatus createUserStatus(UserStatus userStatusRequire);

    List<UserStatus> getAll();

    Map<String, Boolean> deleteUserStatusById(Long userStatusId);

    Object updateUserStatusId(Long userStatusId, UserStatus userStatusDetails);
}
