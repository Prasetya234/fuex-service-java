package com.service.fuex.web.controller;

import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.UserImpl;
import com.service.fuex.web.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<List<UserDTO>> getAll() {
        try {
            return commonResponseGenerator.successResponse(userService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse("Error", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Map<String, Boolean>> deleteUser(@PathVariable(value = "id") Long userId) {
        try {
            return commonResponseGenerator.successResponse(userService.deleteUserById(userId));
        } catch (Exception e) {
            return   commonResponseGenerator.failResponse("Error", e.getMessage());
        }
    }
}
