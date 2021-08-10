package com.service.fuex.web.dto;

import com.service.fuex.web.model.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long userId;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String username;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String fullName;

    @Email(message = "MUST CONTAIN EMAIL")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String email;

    @NotBlank(message = "CAN NOT BE EMPETY")
    @Size(max = 12, message = "MAXIMUM 12 CHARACTERS")
    private String mobilePhoneNumber;

    private UserType userTypeId;

    // SETTER & GETTER
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }
}
