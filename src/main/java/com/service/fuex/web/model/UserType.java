package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    private Long userTypeId;

    private String userTypeName;

    public UserType() {
    }

    public UserType(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Column(name = "user_type_name", nullable = false)
    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
