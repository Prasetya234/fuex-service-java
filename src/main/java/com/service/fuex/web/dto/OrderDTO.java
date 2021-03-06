package com.service.fuex.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDTO {
//    @NotBlank(message = "ATAS NAMA CANNOT EMPTY")
    private String atasNama;

//    @NotBlank(message = "NO TELPON CANNOT EMPTY")
    private String noTelpon;

//    @NotBlank(message = "ALAMAT CANNOT EMPTY")
    private String alamat;

//    @NotBlank(message = "MEREK CANNOT EMPTY")
    private String merek;

//    @NotBlank(message = "NUMBER PLAT CANNOT EMPTY")
    private String numberPlat;

//    @NotNull(message = "LITER CANNOT EMPTY")
    private String liter;

    private String vocher;

//    @NotNull(message = "EMERGENCY CANNOT EMPTY")
    private Boolean isEmergency;

//    @NotBlank(message = "USER CANNOT EMPTY")
    private String users;

//    @NotBlank(message = "VEHICLE TYPE CANNOT EMPTY")
    private String vehicleType;

//    @NotBlank(message = "BIAYA LAYANAN CANNOT EMPTY")
    private Integer biayaLayanan;

//    @NotBlank(message = "FUEL TYPE CANNOT EMPTY")
    private String fuelType;

    public String getAtasNama() {
        return atasNama;
    }

    public void setAtasNama(String atasNama) {
        this.atasNama = atasNama;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getNumberPlat() {
        return numberPlat;
    }

    public void setNumberPlat(String numberPlat) {
        this.numberPlat = numberPlat;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }

    public String getVocher() {
        return vocher;
    }

    public void setVocher(String vocher) {
        this.vocher = vocher;
    }

    public Boolean getEmergency() {
        return isEmergency;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Integer getBiayaLayanan() {
        return biayaLayanan;
    }

    public void setBiayaLayanan(Integer biayaLayanan) {
        this.biayaLayanan = biayaLayanan;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
