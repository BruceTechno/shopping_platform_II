package com.example.shopping_platform_II.vo;

public class AddPayWayRequest {
    private int code ;
    private String payWay;
//==

    public AddPayWayRequest() {
    }
//==

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
