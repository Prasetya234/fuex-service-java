package com.service.fuex.web.service;

import com.service.fuex.web.model.UserStatus;
import com.service.fuex.web.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusImpl implements UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Override
    public UserStatus createUserStatus(UserStatus userStatusRequire) {
        return userStatusRepository.save(userStatusRequire);
    }

    @Override
    public List<UserStatus> getAll() {
        return userStatusRepository.findAll();
    }
}
