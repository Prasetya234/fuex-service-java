package com.service.fuex.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TemporaryOtpDTO {
    private long otpId;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String otpNumber;

    private boolean isVerified;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String email;


    public long getOtpId() {
        return otpId;
    }

    public void setOtpId(long otpId) {
        this.otpId = otpId;
    }

    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
