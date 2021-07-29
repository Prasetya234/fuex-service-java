package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "useres")
public class User {
    private Long userId;

    private String username;

    private String fullName;

    private String email;

    private String mobilePhoneNumber;

    private UserStatus userStatusId;

    private  UserType userTypeId;

    public User() {
    }

    public User(String username, String fullName, String email, String mobilePhoneNumber) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "mobile_phone_number", nullable = false)
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_status_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public UserStatus getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(UserStatus userStatusId) {
        this.userStatusId = userStatusId;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_type_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                '}';
    }
}
