package com.service.fuex.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderes")
public class Order {

    private Long id;

    private String atasNama;

    private String noTelpon;

    private String alamat;

    private String merek;

    private String numberPlat;

    private Integer perLiter;

    private String kodeVocher;

    private Integer totalPembayaran;

    private Date createDate;

    private Boolean isEmergency;

    private String user;

    private User userId;

    private String vehicleType;

    private VehicleType vehicleTypeId;

    private String fuelType;

    private FuelType fuelTypeId;

    private String orderStatus;

    private OrderStatus orderStatusId;

    public Order() {
    }

    public Order(String atasNama, String noTelpon, String alamat, String merek, String numberPlat, Integer perLiter, String kodeVocher, Integer totalPembayaran, Boolean isEmergency, String user, String vehicleType, String fuelType, String orderStatus) {
        this.atasNama = atasNama;
        this.noTelpon = noTelpon;
        this.alamat = alamat;
        this.merek = merek;
        this.numberPlat = numberPlat;
        this.perLiter = perLiter;
        this.kodeVocher = kodeVocher;
        this.totalPembayaran = totalPembayaran;
        this.isEmergency = isEmergency;
        this.user = user;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.orderStatus = orderStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "atas_nama", nullable = false)
    public String getAtasNama() {
        return atasNama;
    }

    public void setAtasNama(String atasNama) {
        this.atasNama = atasNama;
    }

    @Column(name = "no_telpon", nullable = false)
    public String getNoTelpon() {
        return noTelpon;
    }

    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    @Column(name = "alamat", nullable = false)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Column(name = "merek", nullable = false)
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    @Column(name = "number_plat", nullable = false)
    public String getNumberPlat() {
        return numberPlat;
    }

    public void setNumberPlat(String numberPlat) {
        this.numberPlat = numberPlat;
    }

    @Column(name = "per_liter", nullable = false)
    public Integer getPerLiter() {
        return perLiter;
    }

    public void setPerLiter(Integer perLiter) {
        this.perLiter = perLiter;
    }

    @Column(name = "kode_vocher", nullable = false)
    public String getKodeVocher() {
        return kodeVocher;
    }

    public void setKodeVocher(String kodeVocher) {
        this.kodeVocher = kodeVocher;
    }

    @Column(name = "total_pembayaran", nullable = false)
    public Integer getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(Integer totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "is_emergency", nullable = false)
    public Boolean getEmergency() {
        return isEmergency;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    @Column(name = "user", nullable = false)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Column(name = "vehicle_type", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public VehicleType getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleType vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Column(name = "fuel_type", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fuel_type_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public FuelType getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(FuelType fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    @Column(name = "order_status", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_status_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
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
                ", perLiter=" + perLiter +
                ", kodeVocher='" + kodeVocher + '\'' +
                ", totalPembayaran=" + totalPembayaran +
                ", createDate=" + createDate +
                ", isEmergency=" + isEmergency +
                ", user='" + user + '\'' +
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
