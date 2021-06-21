package com.service.fuex.web.service;

import com.service.fuex.web.model.UserType;
import com.service.fuex.web.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
