package com.service.fuex.web.model;


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

    @Column(name = "atas_nama", nullable = false)
    private String atasNama;

    @Column(name = "no_telpon", nullable = false)
    private String noTelpon;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "merek", nullable = false)
    private String merek;

    @Column(name = "number_plat", nullable = false)
    private String numberPlat;

    @Column(name = "per_liter", nullable = false)
    private Integer perLiter;

    @Column(name = "kode_vocher", nullable = false)
    private String kodeVocher;

    @Column(name = "total_pembayaran", nullable = false)
    private Integer totalPembayaran;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "is_emergency", nullable = false)
    private Boolean isEmergency;

    @Column(name = "users", nullable = false)
    private String users;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userId;

    @Column(name = "vehicle_type", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String vehicleType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private VehicleType vehicleTypeId;

    @Column(name = "fuel_type", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String fuelType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fuel_type_id", nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FuelType fuelTypeId;

    @Column(name = "order_status", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String orderStatus;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_status_id", nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderStatus orderStatusId;

    public Order() {
    }

    public Order(String atasNama, String noTelpon, String alamat, String merek, String numberPlat, Integer perLiter, String kodeVocher, Integer totalPembayaran, Boolean isEmergency, String users, String vehicleType, String fuelType, String orderStatus) {
        this.atasNama = atasNama;
        this.noTelpon = noTelpon;
        this.alamat = alamat;
        this.merek = merek;
        this.numberPlat = numberPlat;
        this.perLiter = perLiter;
        this.kodeVocher = kodeVocher;
        this.totalPembayaran = totalPembayaran;
        this.isEmergency = isEmergency;
        this.users = users;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.orderStatus = orderStatus;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

    @Override
    public String   toString() {
        return "Order{" +
                "id=" + id +
                ", atasNama='" + atasNama + '\'' +
                ", noTelpon='" + noTelpon + '\'' +
                ", alamat='" + alamat + '\'' +
                ", merek='" + merek + '\'' +
                ", numberPlat='" + numberPlat + '\'' +
                ", perLiter=" + perLiter +
                ", kodeVocher='" + kodeVocher + '\'' +
                ", totalPembayaran=" + totalPembayaran +
                ", createDate=" + createDate +
                ", isEmergency=" + isEmergency +
                ", users='" + users + '\'' +
                ", userId=" + userId +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleTypeId=" + vehicleTypeId +
                ", fuelType='" + fuelType + '\'' +
                ", fuelTypeId=" + fuelTypeId +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderStatusId=" + orderStatusId +
                '}';
    }
}
