package com.service.fuex.web.dto;

import com.service.fuex.web.model.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {


    @NotBlank(message = "USERNAME CANNOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String username;

    @NotBlank(message = "FULL NAME CANNOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String fullName;

    @NotNull(message = "EMAIL CANNOT BE EMPTY")
    @Email(message = "MUST CONTAIN EMAIL")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String email;

    @NotNull(message = "MOBILE PHONE NUMBER CAN NOT BE EMPTY")
    @Size(max = 12, message = "MAXIMUM 12 CHARACTERS")
    private String mobilePhoneNumber;

    // SETTER & GETTER

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
}
