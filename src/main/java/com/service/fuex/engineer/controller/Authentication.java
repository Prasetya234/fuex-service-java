package com.service.fuex.engineer.controller;

import com.service.fuex.engineer.service.ValidateImpl;
import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Authentication {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ValidateImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTORequire) throws ResourceNotFoundExceotion {
        User userDTO = modelMapper.map(userDTORequire, User.class);

        User user = userService.register(userDTO);

        UserDTO response = modelMapper.map(user, UserDTO.class);

        return commonResponseGenerator.successResponse(response);
    }
}
