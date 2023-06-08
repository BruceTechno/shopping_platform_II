package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.ShoppingCar;

import java.util.List;

public class GetShoppingCarResponse {
private String message;
private List<GetCommodityInfo> getCommodityInfoList;

//===

    public GetShoppingCarResponse() {
    }

    public GetShoppingCarResponse(String message) {
        this.message = message;
    }



    public GetShoppingCarResponse(String message, List<GetCommodityInfo> getCommodityInfoList) {
        this.message = message;
        this.getCommodityInfoList = getCommodityInfoList;
    }
    //==

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public List<GetCommodityInfo> getGetCommodityInfoList() {
        return getCommodityInfoList;
    }

    public void setGetCommodityInfoList(List<GetCommodityInfo> getCommodityInfoList) {
        this.getCommodityInfoList = getCommodityInfoList;
    }
}
