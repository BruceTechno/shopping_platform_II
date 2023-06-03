package com.example.shopping_platform_II.vo;

public class AddCommodityResponse {
    private String message;
//=============================================

    public AddCommodityResponse() {
    }

    public AddCommodityResponse(String message) {
        this.message = message;
    }
//=============================================

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
