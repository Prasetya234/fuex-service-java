package com.service.fuex.web.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderes")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atas_nama")
    private String atasNama;

    @Column(name = "no_telpon")
    private String noTelpon;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "merek")
    private String merek;

    @Column(name = "number_plat")
    private String numberPlat;

    @Column(name = "liter")
    private String liter;

    @Column(name = "biaya_layanan")
    private String biayaLayanan;

    @Column(name = "total_pembayaran")
    private Integer totalPembayaran;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_emergency")
    private Boolean isEmergency;

    @Column(name = "users")
    private String users;

    @Column(name = "vehicle_type")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String vehicleType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VehicleType vehicleTypeId;

    @Column(name = "fuel_type")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String fuelType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fuel_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FuelType fuelTypeId;

    @Column(name = "vocher")
    private String vocher;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "vocher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vocher vocherId;

    @Column(name = "order_status")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String orderStatus;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_status_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderStatus orderStatusId;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getBiayaLayanan() {
        return biayaLayanan;
    }

    public void setBiayaLayanan(String biayaLayanan) {
        this.biayaLayanan = biayaLayanan;
    }

    public Integer getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(Integer totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleType vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public FuelType getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(FuelType fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getVocher() {
        return vocher;
    }

    public void setVocher(String vocher) {
        this.vocher = vocher;
    }

    public Vocher getVocherId() {
        return vocherId;
    }

    public void setVocherId(Vocher vocherId) {
        this.vocherId = vocherId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", atasNama='" + atasNama + '\'' +
                ", noTelpon='" + noTelpon + '\'' +
                ", alamat='" + alamat + '\'' +
                ", merek='" + merek + '\'' +
                ", numberPlat='" + numberPlat + '\'' +
                ", liter='" + liter + '\'' +
                ", biayaLayanan='" + biayaLayanan + '\'' +
                ", totalPembayaran='" + totalPembayaran + '\'' +
                ", createDate=" + createDate +
                ", isEmergency=" + isEmergency +
                ", users='" + users + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleTypeId=" + vehicleTypeId +
                ", fuelType='" + fuelType + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                ", vocher='" + vocher + '\'' +
                ", vocherId=" + vocherId +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderStatusId=" + orderStatusId +
                '}';
    }
}
