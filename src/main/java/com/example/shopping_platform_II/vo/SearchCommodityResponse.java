package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.Commodity;

import java.util.List;

public class SearchCommodityResponse {
    private String message ;
    private List<Commodity> commodityList;
    private int number;
    private String name;
    private String category;
    private int inventory;
    private int price;
    private String accountSell;
//==

    public SearchCommodityResponse() {
    }

    public SearchCommodityResponse(String message) {
        this.message = message;
    }

    public SearchCommodityResponse(String message, List<Commodity> commodityList) {
        this.message = message;
        this.commodityList = commodityList;
    }

    public SearchCommodityResponse(int number, String name, String category, int inventory, int price, String accountSell) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
        this.accountSell = accountSell;
    }
    //====

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
