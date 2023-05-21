package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.User;

public class UpdateResponse {
    private String message;

    private User user;
//==================================================================


    public UpdateResponse() {
    }

    public UpdateResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }
//==================================================================

    public String getMessage() {
        return message;
    }

    public UpdateResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
