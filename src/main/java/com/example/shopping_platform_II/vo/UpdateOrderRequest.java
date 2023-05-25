package com.example.shopping_platform_II.vo;

import java.util.Map;

public class UpdateOrderRequest {
    private int orderNumber;
    private Map<Integer, Integer> orderInfos;
//===============================================================================

    public UpdateOrderRequest() {
    }
//===============================================================================

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Map<Integer, Integer> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(Map<Integer, Integer> orderInfos) {
        this.orderInfos = orderInfos;
    }
}
