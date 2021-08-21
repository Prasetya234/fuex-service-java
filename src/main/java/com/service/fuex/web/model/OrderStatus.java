package com.service.fuex.web.model;

import javax.persistence.*;

@Entity
@Table(name = "order_statuses")
public class OrderStatus {
    private Long orderStatusId;
    private String orderStatusName;

    public OrderStatus() {
    }

    public OrderStatus(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Column(name = "order_status_name", nullable = false)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
}
