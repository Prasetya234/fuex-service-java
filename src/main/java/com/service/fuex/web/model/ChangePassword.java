package com.service.fuex.web.model;

import javax.validation.constraints.NotNull;

public class ChangePassword {

    @NotNull
    private String code;

    @NotNull
    private String newPassword;

    @NotNull
    private String confirmPassword;

    public ChangePassword() {
    }

    public ChangePassword(String code, String newPassword, String confirmPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
