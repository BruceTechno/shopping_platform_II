package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.PayWayCode;

import java.util.List;

public class GetPayWayResponse {
    private String message;
    private List<PayWayCode> payWayCodeList;
//==

    public GetPayWayResponse() {
    }

    public GetPayWayResponse(String message, List<PayWayCode> payWayCodeList) {
        this.message = message;
        this.payWayCodeList = payWayCodeList;
    }
//==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PayWayCode> getPayWayCodeList() {
        return payWayCodeList;
    }

    public void setPayWayCodeList(List<PayWayCode> payWayCodeList) {
        this.payWayCodeList = payWayCodeList;
    }
}
