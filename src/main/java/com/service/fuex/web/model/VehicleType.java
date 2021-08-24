package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicle_typees")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleType {
    private Long vehicleTypeId;
    private String tipeKendaraan;
    private Set<FuelType> fuelTypeId = new HashSet<>();

    public VehicleType() {
    }

    public VehicleType(String tipeKendaraan) {
        this.tipeKendaraan = tipeKendaraan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Column(name = "tipe_kendaraan", nullable = false)
    public String getTipeKendaraan() {
        return tipeKendaraan;
    }

    public void setTipeKendaraan(String tipeKendaraan) {
        this.tipeKendaraan = tipeKendaraan;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "vehicleType", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Set<FuelType> getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Set<FuelType> fuelTypeId) {
        this.fuelTypeId = fuelTypeId;

        for(FuelType b : fuelTypeId) {
            b.setVehicleType(this);
        }
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "vehicleTypeId=" + vehicleTypeId +
                ", tipeKendaraan='" + tipeKendaraan + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                '}';
    }
}
