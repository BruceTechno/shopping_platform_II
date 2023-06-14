package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.Commodity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class UpdateCommodityResponse {
    private String message;
    private List<Commodity> commodityList;
//===================

    public UpdateCommodityResponse() {
    }

    public UpdateCommodityResponse(String message) {
        this.message = message;
    }

    public UpdateCommodityResponse(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
    //===================

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
