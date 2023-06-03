package com.example.shopping_platform_II.vo;

public class DeliverWayRequest {
    private int code;
    private String deliveryWay;
//==

    public DeliverWayRequest() {
    }
//==

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
