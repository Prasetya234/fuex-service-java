package com.service.fuex.web.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vocheres")
public class Vocher {

    private Long vocherId;
    private String code;
    private Integer inUseCount;
    private Date expiredDate;
    private String image;
    private Integer discount;

    public Vocher() {
    }

    public Vocher(String code, String image, Date expiredDate, Integer discount, Integer inUseCount) {
        this.inUseCount = inUseCount;
        this.expiredDate = expiredDate;
        this.code = code;
        this.image = image;
        this.discount = discount;
    }

    public Vocher(String code) {
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getVocherId() {
        return vocherId;
    }

    public void setVocherId(Long vocherId) {
        this.vocherId = vocherId;
    }

    @Column(name= "code", nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "use_count")
    public Integer getInUseCount() {
        return inUseCount;
    }

    public void setInUseCount(Integer inUseCount) {
        this.inUseCount = inUseCount;
    }

    @Column(name = "expired")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Lob
    @Column(name = "image", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "discount", nullable = false)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Vocher{" +
                "id=" + vocherId +
                ", code='" + code + '\'' +
                ", use=" + inUseCount +
                ", expiredDate=" + expiredDate +
                ", image='" + image + '\'' +
                ", discount=" + discount +
                '}';
    }
}
