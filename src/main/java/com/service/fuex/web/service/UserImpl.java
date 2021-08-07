package com.service.fuex.web.service;

import com.service.fuex.web.model.User;
import com.service.fuex.web.repository.UserRepository;
import com.service.fuex.web.repository.UserStatusRepository;
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
    private UserStatusRepository userStatusRepository;

    @Autowired
    private Configuration config;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public String getUserById(Long userId) throws TemplateException, IOException {
        var user = userRepository.findById(userId).get();
        var checkingStatusUser = userStatusRepository.getById(2L);
        user.setUserStatusId(checkingStatusUser);
        var somuch = userRepository.save(user);
        Map<String, Object> templates = new HashMap<>();
        templates.put("username",  somuch.getUsername());
        Template t = config.getTemplate("template-access.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(t, templates);
    }
}
