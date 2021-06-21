package com.service.fuex.web.service;

import com.service.fuex.web.model.User;
import com.service.fuex.web.model.UserStatus;

import java.util.List;

public interface UserStatusService {
    UserStatus createUserStatus(UserStatus userStatusRequire);

    List<UserStatus> getAll();
}
