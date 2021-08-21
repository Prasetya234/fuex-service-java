package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "fuel_typees")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class FuelType {
    private Long fuelTypeId;
    private String tipeBensin;
    private int price;
    private int capacity;
    private VehicleType vehicleType;

    public FuelType() {
    }

    public FuelType(String tipeBensin, int price, int capacity) {
        this.tipeBensin = tipeBensin;
        this.price = price;
        this.capacity = capacity;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
    @JoinColumn(name = "vehicle_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", tipeBensin='" + tipeBensin + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
