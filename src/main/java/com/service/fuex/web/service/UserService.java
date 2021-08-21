package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll(String access) throws ResourceNotFoundExceotion;

    Map<String, Boolean> deleteUserById(Long userStatusId, String access) throws ResourceNotFoundExceotion;

    User getUserById(Long userId, String access) throws ResourceNotFoundExceotion;
}
