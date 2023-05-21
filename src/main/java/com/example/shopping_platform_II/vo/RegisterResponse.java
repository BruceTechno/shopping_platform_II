package com.example.shopping_platform_II.vo;

public class RegisterResponse {
    private String message ;
//================================================================================

    public RegisterResponse(String message) {
        this.message = message;
    }

    public RegisterResponse() {
    }
//================================================================================

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
