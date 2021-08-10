package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "useres")
public class User {
    private Long userId;

    private String username;

    private String fullName;

    private String email;

    private String mobilePhoneNumber;

    private  UserType userTypeId;

    public User() {
    }

    public User(String username, String fullName, String email, String mobilePhoneNumber, UserType userTypeId) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.userTypeId = userTypeId;
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
    @JoinColumn(name = "user_type_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }
}
