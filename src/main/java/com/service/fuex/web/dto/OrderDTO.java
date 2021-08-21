package com.service.fuex.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDTO {
    @NotBlank(message = "ATAS NAMA CANNOT EMPTY")
    private String atasNama;

    @NotBlank(message = "NO TELPON CANNOT EMPTY")
    private String noTelpon;

    @NotBlank(message = "ALAMAT CANNOT EMPTY")
    private String Alamat;

    @NotBlank(message = "MEREK CANNOT EMPTY")
    private String merek;

    @NotBlank(message = "NUMBER PLAT CANNOT EMPTY")
    private String numberPlat;

    @NotNull(message = "PERLITER CANNOT EMPTY")
    private Integer perLiter;

    @NotBlank(message = "KODE VOCHER CANNOT EMPTY")
    private String kodeVocher;

    @NotNull(message = "TOTAL PEMBAYARAN CANNOT EMPTY")
    private Integer totalPembayaran;

    @NotNull(message = "EMERGENCY CANNOT EMPTY")
    private Boolean isEmergency;

    @NotBlank(message = "USER CANNOT EMPTY")
    private String user;

    @NotBlank(message = "VEHICLE TYPE CANNOT EMPTY")
    private String vehicleType;

    @NotBlank(message = "FUEL TYPE CANNOT EMPTY")
    private String fuelType;

    @NotBlank(message = "ORDER STATUS CANNOT EMPTY")
    private String orderStatus;

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
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
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

    public Integer getPerLiter() {
        return perLiter;
    }

    public void setPerLiter(Integer perLiter) {
        this.perLiter = perLiter;
    }

    public String getKodeVocher() {
        return kodeVocher;
    }

    public void setKodeVocher(String kodeVocher) {
        this.kodeVocher = kodeVocher;
    }

    public Integer getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(Integer totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public Boolean getEmergency() {
        return isEmergency;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
