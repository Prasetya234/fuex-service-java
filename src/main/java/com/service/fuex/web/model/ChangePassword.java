package com.service.fuex.web.model;

import javax.validation.constraints.NotBlank;

public class ChangePassword {

    @NotBlank
    private String accessCode;

    @NotBlank
    private String newPassword;

    @NotBlank
    private String confirmPassword;

    public ChangePassword() {
    }

    public ChangePassword(String accessCode, String newPassword, String confirmPassword) {
        this.accessCode = accessCode;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
