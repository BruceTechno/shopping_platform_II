package com.example.shopping_platform_II.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class DistinctSearchResponse {
    private int number;
    private String name;
    private String category;
    private int inventory;
    private int price;
    private String accountSell;
    private List<DistinctSearchResponse> distinctSearchResponseList;
    private String message;
//==

    public DistinctSearchResponse() {
    }

    public DistinctSearchResponse(int number, String name, String category, int inventory, int price, String accountSell) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.inventory = inventory;
        this.price = price;
        this.accountSell = accountSell;
    }

    public DistinctSearchResponse(List<DistinctSearchResponse> distinctSearchResponseList, String message) {
        this.distinctSearchResponseList = distinctSearchResponseList;
        this.message = message;
    }

    public DistinctSearchResponse(String message) {
        this.message = message;
    }
    //==

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

    public List<DistinctSearchResponse> getDistinctSearchResponseList() {
        return distinctSearchResponseList;
    }

    public void setDistinctSearchResponseList(List<DistinctSearchResponse> distinctSearchResponseList) {
        this.distinctSearchResponseList = distinctSearchResponseList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
