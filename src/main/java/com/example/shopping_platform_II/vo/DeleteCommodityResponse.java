package com.example.shopping_platform_II.vo;

public class DeleteCommodityResponse {
    private String message ;
//==

    public DeleteCommodityResponse() {
    }

    public DeleteCommodityResponse(String message) {
        this.message = message;
    }
//==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
