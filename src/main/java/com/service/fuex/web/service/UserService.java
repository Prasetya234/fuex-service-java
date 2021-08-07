package com.service.fuex.web.service;

import com.service.fuex.web.model.User;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll();

    Map<String, Boolean> deleteUserById(Long userStatusId);

    String getUserById(Long userId) throws TemplateException, IOException;
}