package com.example.shopping_platform_II.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_info")
public class Order {
    @Id
    @Column(name = "order_number")
    private int orderNumber;
    @Column(name = "account")
    private String account;
    @Column(name = "order_info")
    private String orderInfo;
    @Column(name = "pay_way")
    private int payWay;
    @Column(name = "delivery_way")
    private int deliveryWay;
    @Column(name = "status")
    private int status;
//====================================================================================================
    public Order() {
    }
//====================================================================================================

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public int getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(int deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
