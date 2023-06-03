package com.example.shopping_platform_II.vo;

public class DeletePayWayResponse {
    private String message ;
//===

    public DeletePayWayResponse() {
    }

    public DeletePayWayResponse(String message) {
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
