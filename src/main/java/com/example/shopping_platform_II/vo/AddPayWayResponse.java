package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.PayWayCode;

public class AddPayWayResponse {
    private String message;
    private PayWayCode payWayCode;
//====

    public AddPayWayResponse() {
    }

    public AddPayWayResponse(String message) {
        this.message = message;
    }

    public AddPayWayResponse(String message, PayWayCode payWayCode) {
        this.message = message;
        this.payWayCode = payWayCode;
    }
    //==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
