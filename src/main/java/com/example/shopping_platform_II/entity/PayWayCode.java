package com.example.shopping_platform_II.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pay_way_code")
public class PayWayCode {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "pay_way")
    private String payWay;
//============================================================================================

    public PayWayCode() {
    }
//============================================================================================

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}
