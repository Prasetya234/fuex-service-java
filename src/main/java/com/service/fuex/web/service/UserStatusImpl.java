package com.service.fuex.web.service;

import com.service.fuex.web.model.UserStatus;
import com.service.fuex.web.repository.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public Map<String, Boolean> deleteUserStatusById(Long userStatusId) {
        userStatusRepository.deleteById(userStatusId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    @Override
    public UserStatus updateUserStatusId(Long userStatusId, UserStatus userStatusDetails) {
        UserStatus userStatus = userStatusRepository.findById(userStatusId).get();
        userStatus.setUserStatusName(userStatusDetails.getUserStatusName());
        return userStatusRepository.save(userStatus);
    }
}
