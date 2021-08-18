package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "useres")
public class User {
    private Long userId;

    private String username;

    private String fullName;

    private String password;

    private String email;

    private String mobilePhoneNumber;

    private Date createAt;

    private Date updateAt;

    private String userType;

    private  UserType userTypeId;

    public User() {
    }

    public User(String username, String fullName, String email, String mobilePhoneNumber, String userType) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.userType = userType;
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

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @Column(name = "created_at")
    public Date getCreateAt() {
        return createAt;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @Column(name = "update_at")
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Column(name = "user_type")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
