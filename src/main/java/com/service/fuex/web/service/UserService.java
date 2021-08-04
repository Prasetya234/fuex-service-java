package com.service.fuex.web.service;

import com.service.fuex.web.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll();

    Map<String, Boolean> deleteUserById(Long userStatusId);
}
