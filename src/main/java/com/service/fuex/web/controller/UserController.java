package com.service.fuex.web.controller;

import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.UserImpl;
import freemarker.template.TemplateException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public CommonResponse<List<UserDTO>> getAll(@RequestHeader(value = "access") String access){
        try {
            return commonResponseGenerator.successResponse(userService.getAll(access));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Map<String, Boolean>> deleteUser(@PathVariable(value = "id") Long userId) {
        try {
            return commonResponseGenerator.successResponse(userService.deleteUserById(userId));
        } catch (Exception e) {
            return   commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/access/{id}")
    public String getUser(@PathVariable(value = "id") Long userId) throws TemplateException, IOException {
        return userService.getUserById(userId);
    }
}
