package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "temporary_otp")
public class TemporaryOtp {
    private long otpId;

    private String otpNumber;

    private boolean isVerified;

    private String email;


    public TemporaryOtp() {
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

    @Column(name = "is_verified", nullable = true)
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

    @Override
    public String toString() {
        return "TemporaryOtp{" +
                "otpId=" + otpId +
                ", otpNumber='" + otpNumber + '\'' +
                ", isVerified=" + isVerified +
                ", email='" + email + '\'' +
                '}';
    }
}
