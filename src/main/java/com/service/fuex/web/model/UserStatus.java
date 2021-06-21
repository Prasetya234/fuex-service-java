package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "user_status")
public class UserStatus {
    private Long userStatusId;

    private String userStatusName;

    public UserStatus() {
    }

    public UserStatus(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }

    @Column(name = "user_status_name", nullable = false)
    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "userStatusId=" + userStatusId +
                ", userStatusName='" + userStatusName + '\'' +
                '}';
    }
}
