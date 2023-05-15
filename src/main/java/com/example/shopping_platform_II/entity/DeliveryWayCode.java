package com.example.shopping_platform_II.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_way_code")
public class DeliveryWayCode {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "delivery_way")
    private String deliveryWay;
//================================================================================================

    public DeliveryWayCode() {
    }
//================================================================================================

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }
}
