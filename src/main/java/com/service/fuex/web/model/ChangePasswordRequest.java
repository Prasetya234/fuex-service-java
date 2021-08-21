package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "change_password_request")
public class ChangePasswordRequest {
    private Long id;
    private String code;
    private String Email;
    private Boolean alreadyUsed;

    public ChangePasswordRequest() {
    }

    public ChangePasswordRequest(String code, String email) {
        this.code = code;
        Email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Column(name = "already_used")
    public Boolean getAlreadyUsed() {
        return alreadyUsed;
    }

    public void setAlreadyUsed(Boolean alreadyUsed) {
        this.alreadyUsed = alreadyUsed;
    }

    @Override
    public String toString() {
        return "ChangePasswordRequest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", Email='" + Email + '\'' +
                ", alreadyUsed=" + alreadyUsed +
                '}';
    }
}
