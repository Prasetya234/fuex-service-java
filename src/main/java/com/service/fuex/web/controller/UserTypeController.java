package com.service.fuex.web.controller;

import com.service.fuex.web.dto.UserTypeDTO;
import com.service.fuex.web.model.UserType;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.UserTypeImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reference/user-type/")
public class UserTypeController {
    @Autowired
    private UserTypeImpl userTypeService;

    @Autowired private ModelMapper modelMapper;

    @Autowired private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<List<UserTypeDTO>> getAll() {

        Stream<Object> userTypeList = userTypeService.getAll().stream().map(userType -> modelMapper.map(userType, UserTypeDTO.class));

        return commonResponseGenerator.successResponse(userTypeList);
    }

    @PostMapping
    public CommonResponse<UserTypeDTO> createArticleStatus(@Valid @RequestBody UserTypeDTO userTypeDTORequire) {

        UserType userTypeRequire = modelMapper.map(userTypeDTORequire, UserType.class);

        UserType userType = userTypeService.createUserType(userTypeRequire);

        UserTypeDTO response = modelMapper.map(userType, UserTypeDTO.class);

        return commonResponseGenerator.successResponse(response);
    }

    @PutMapping("/{id}")
    public CommonResponse<UserType> updateUserStatus(@PathVariable(value = "id") Long userStatusId, @Valid @RequestBody UserType userType){
        try {
            return commonResponseGenerator.successResponse(userTypeService.updateUserType(userStatusId, userType));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse( e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public CommonResponse<Map<String, Boolean>> deleteUserStatus(@PathVariable(value = "id") Long userTypeId) {
        try {
            return commonResponseGenerator.successResponse(userTypeService.deleteUsertype(userTypeId));
        } catch (Exception e) {
            return   commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
