package com.example.shopping_platform_II.vo;

public class AddShoppingCarResponse {
    private String message;
//==

    public AddShoppingCarResponse() {
    }

    public AddShoppingCarResponse(String message) {
        this.message = message;
    }
//===

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
