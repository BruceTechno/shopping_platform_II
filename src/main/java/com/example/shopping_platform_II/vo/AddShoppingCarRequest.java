package com.example.shopping_platform_II.vo;

public class AddShoppingCarRequest {
    private String userId;
    private int commodityNumber;
    private int quantity;
//===

    public AddShoppingCarRequest() {
    }
//===

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
