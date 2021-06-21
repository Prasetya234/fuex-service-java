package com.service.fuex.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserStatusDTO {
    private Long userStatusId;

    @NotBlank(message = "CAN NOT BE EMPTY")
    @Size(max = 255, message = "MAXIMUM 255 CHARACTERS")
    private String userStatusName;

    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }

    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }
}
