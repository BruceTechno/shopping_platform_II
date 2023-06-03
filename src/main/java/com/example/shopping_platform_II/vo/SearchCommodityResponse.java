package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.Commodity;

import java.util.List;

public class SearchCommodityResponse {
    private String message ;
    private List<Commodity> commodityList;

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


}
