package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "fuel_type")
public class FuelType {
    private Long fuelTypeId;
    private String tipeBensin;
    private int price;
    private int capacity;
    private String vehicleTypeName;
    private VehicleType vehicleType;

    public FuelType() {
    }

    public FuelType(String tipeBensin, int price, int capacity, String vehicleTypeName) {
        this.tipeBensin = tipeBensin;
        this.price = price;
        this.capacity = capacity;
        this.vehicleTypeName = vehicleTypeName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    @Column(name = "tipe_bensin")
    public String getTipeBensin() {
        return tipeBensin;
    }

    public void setTipeBensin(String tipeBensin) {
        this.tipeBensin = tipeBensin;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
    @JoinColumn(name = "vehicle_type_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Column(name = "vehicle_type_name")
    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", tipeBensin='" + tipeBensin + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", vehicleTypeName='" + vehicleTypeName + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
