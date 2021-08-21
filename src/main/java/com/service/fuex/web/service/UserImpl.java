package com.service.fuex.web.service;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.UserRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Configuration config;

    @Override
    public List<User> getAll(String access) throws ResourceNotFoundExceotion {
      if (access.equals("FUEX")) {
          return userRepository.findAll();
      }
      throw  new ResourceNotFoundExceotion("ACCESS BLOCKED");
    }

    @Override
    public Map<String, Boolean> deleteUserById(Long userId, String access) throws ResourceNotFoundExceotion {
        if (access.equals("FUEX")) {
            userRepository.deleteById(userId);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            return response;
        }
        throw  new ResourceNotFoundExceotion("ACCESS BLOCKED");
    }

    @Override
    public User getUserById(Long userId, String access) throws ResourceNotFoundExceotion {
        if (access.equals("FUEX")) {
            var user = userRepository.findById(userId).get();
            if (user == null) {
                throw new ResourceNotFoundExceotion("USER ID NOT FOUND");
            }
            return user;
        }
        throw  new ResourceNotFoundExceotion("ACCESS BLOCKED");
    }
}
