package com.example.shopping_platform_II.vo;

public class UpdateCommodityResponse {
    private String message;
//===================

    public UpdateCommodityResponse() {
    }

    public UpdateCommodityResponse(String message) {
        this.message = message;
    }
//===================

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
