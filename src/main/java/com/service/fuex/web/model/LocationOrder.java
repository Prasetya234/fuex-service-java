package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class LocationOrder {

    private Long id;
    private String lokasi;

    public LocationOrder() {
    }

    public LocationOrder(String lokasi) {
        this.lokasi = lokasi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "lokasi", nullable = false)
    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
