package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.DeliveryWayCode;

import java.util.List;

public class DeliverWayResponse {
    private String message;
    private DeliveryWayCode deliveryWayCode;
    private List<DeliveryWayCode> deliveryWayCodeList;
//==

    public DeliverWayResponse() {
    }

    public DeliverWayResponse(String message) {
        this.message = message;
    }

    public DeliverWayResponse(String message, DeliveryWayCode deliveryWayCode) {
        this.message = message;
        this.deliveryWayCode = deliveryWayCode;
    }

    public DeliverWayResponse(String message, List<DeliveryWayCode> deliveryWayCodeList) {
        this.message = message;
        this.deliveryWayCodeList = deliveryWayCodeList;
    }
    //==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DeliveryWayCode getDeliveryWayCode() {
        return deliveryWayCode;
    }

    public void setDeliveryWayCode(DeliveryWayCode deliveryWayCode) {
        this.deliveryWayCode = deliveryWayCode;
    }

    public List<DeliveryWayCode> getDeliveryWayCodeList() {
        return deliveryWayCodeList;
    }

    public void setDeliveryWayCodeList(List<DeliveryWayCode> deliveryWayCodeList) {
        this.deliveryWayCodeList = deliveryWayCodeList;
    }
}
