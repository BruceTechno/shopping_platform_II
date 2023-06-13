package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping(value = "add_commodity")
    public AddCommodityResponse addCommodity(HttpSession session, @RequestBody AddCommodityRequest request) {
        return commodityService.addCommodity(session, request);
    }

    @PostMapping(value = "delete_commodity")
    public DeleteCommodityResponse deleteCommodity(HttpSession session, @RequestBody DeleteCommodityRequest request) {
        return commodityService.deleteCommodity(session ,request);
    }
    @PostMapping(value = "update_commodity_name_by_number")
    public UpdateCommodityResponse updateNameByNumber(HttpSession session, @RequestBody UpdateCommodityRequest request) {
        return commodityService.updateNameByNumber(session,request);
    }
    @PostMapping(value = "update_commodity_category_by_number")
    public UpdateCommodityResponse updateCategoryByNumber(HttpSession session,@RequestBody UpdateCommodityRequest request) {
        return commodityService.updateCategoryByNumber(session,request);
    }
    @PostMapping(value = "update_commodity_inventory_by_number")
    public UpdateCommodityResponse updateInventoryByNumber(HttpSession session,@RequestBody UpdateCommodityRequest request) {
        return commodityService.updateInventoryByNumber(session,request);
    }
    @PostMapping(value = "update_commodity_price_by_number")
    public UpdateCommodityResponse updatePriceByNumber(HttpSession session,@RequestBody UpdateCommodityRequest request) {
        return commodityService.updatePriceByNumber(session,request);
    }
    @PostMapping(value = "distinctSearchCommodityByName")
    public DistinctSearchResponse distinctSearchCommodityByName(HttpSession session,@RequestBody SearchCommodityRequest request){
        return commodityService.distinctSearchCommodityByName(session,request);
    }
    @PostMapping(value = "distinctSearchCommodityByCategory")
    public DistinctSearchResponse distinctSearchCommodityByCategory(HttpSession session,@RequestBody SearchCommodityRequest request){
        return commodityService.distinctSearchCommodityByCategory(session,request);
    }
    @PostMapping(value = "distinctSearchCommodityByNameOrCategory")
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory(HttpSession session,@RequestBody SearchCommodityRequest request){{
        return commodityService.distinctSearchCommodityByNameOrCategory(session,request);
    }}


}
