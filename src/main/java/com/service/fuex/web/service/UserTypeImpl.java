package com.service.fuex.web.service;

import com.service.fuex.web.model.UserType;
import com.service.fuex.web.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserTypeImpl implements UserTypeService{
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType createUserType(UserType userTypeRequire) {
        return userTypeRepository.save(userTypeRequire);
    }

    @Override
    public UserType updateUserType(Long userId, UserType userType) {
        var update = userTypeRepository.findById(userId).get();
        update.setUserTypeName(userType.getUserTypeName());
        return  userTypeRepository.save(update);
    }

    @Override
    public Map<String, Boolean> deleteUsertype(Long userStatusId) {
        userTypeRepository.deleteById(userStatusId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
