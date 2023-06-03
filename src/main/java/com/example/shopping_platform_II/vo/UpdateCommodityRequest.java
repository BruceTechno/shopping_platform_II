package com.example.shopping_platform_II.vo;

public class UpdateCommodityRequest {
    private int commodityNumber ;
    private String name;
    private String category;
    private int inventory;
    private int price;
    private String accountSell;
//==================================================================

    public UpdateCommodityRequest() {
    }
//==================================================================


    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
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
