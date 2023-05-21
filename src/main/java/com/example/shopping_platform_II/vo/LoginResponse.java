package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.User;

public class LoginResponse {
    private String message;
    private User user;
    private String sessionId;
    private int verifyCode;

//========================================================

    public LoginResponse() {
    }

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }
    //========================================================

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
