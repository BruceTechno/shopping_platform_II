package com.example.shopping_platform_II.vo;

public class GetCommodityInfo {
    private String userId;
    private int commodityNumber;
    private int quantity;
    private String name;
    private String category;
    private int inventory;
    private int price;
    private String accountSell;

//==

    public GetCommodityInfo() {
    }

    public GetCommodityInfo(String userId, int commodityNumber, int quantity, String name, String category, int inventory, int price, String accountSell) {
        this.userId = userId;
        this.commodityNumber = commodityNumber;
        this.quantity = quantity;
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
        this.accountSell = accountSell;
    }

    //==


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAccountSell() {
        return accountSell;
    }

    public void setAccountSell(String accountSell) {
        this.accountSell = accountSell;
    }

}
