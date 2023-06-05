package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.ShoppingCar;

import java.util.List;

public class GetShoppingCarResponse {
private String message;
private List<ShoppingCar> shoppingCarList;

//===

    public GetShoppingCarResponse() {
    }

    public GetShoppingCarResponse(String message) {
        this.message = message;
    }

    public GetShoppingCarResponse(String message, List<ShoppingCar> shoppingCarList) {
        this.message = message;
        this.shoppingCarList = shoppingCarList;
    }
//==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ShoppingCar> getShoppingCarList() {
        return shoppingCarList;
    }

    public void setShoppingCarList(List<ShoppingCar> shoppingCarList) {
        this.shoppingCarList = shoppingCarList;
    }
}
