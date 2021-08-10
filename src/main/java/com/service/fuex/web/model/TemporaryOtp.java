package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "temporary_otp")
public class TemporaryOtp {
    private long otpId;

    private String otpNumber;

    private boolean isVerified;

    private String email;

    private Date expiredDate;

    public TemporaryOtp() {
    }

    public TemporaryOtp(String otpNumber, Date expiredDate, boolean isVerified, String email) {
        this.otpNumber = otpNumber;
        this.isVerified = isVerified;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getOtpId() {
        return otpId;
    }

    public void setOtpId(long otpId) {
        this.otpId = otpId;
    }

    @Column(name = "otp_number", nullable = true)
    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

    @Column(name = "is_verified")
    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @Column(name = "date_expired")
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "TemporaryOtp{" +
                "otpId=" + otpId +
                ", otpNumber='" + otpNumber + '\'' +
                ", isVerified=" + isVerified +
                ", email='" + email + '\'' +
                ", expiresAt=" + expiredDate +
                '}';
    }
}
