package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@CrossOrigin
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @PostMapping(value = "add_commodity")
    public AddCommodityResponse addCommodity(HttpSession session, @RequestBody AddCommodityRequest request) throws IOException {
        return commodityService.addCommodity(session, request);
    }

    @PostMapping(value = "delete_commodity")
    public DeleteCommodityResponse deleteCommodity(HttpSession session, @RequestBody DeleteCommodityRequest request) {
        return commodityService.deleteCommodity(session, request);
    }

    @PostMapping(value = "update_commodity_name_by_number")
    public UpdateCommodityResponse updateNameByNumber(HttpSession session, @RequestBody UpdateCommodityRequest request) {
        return commodityService.updateNameByNumber(session, request);
    }

    @PostMapping(value = "update_commodity_category_by_number")
    public UpdateCommodityResponse updateCategoryByNumber(HttpSession session, @RequestBody UpdateCommodityRequest request) {
        return commodityService.updateCategoryByNumber(session, request);
    }

    @PostMapping(value = "update_commodity_inventory_by_number")
    public UpdateCommodityResponse updateInventoryByNumber(HttpSession session, @RequestBody UpdateCommodityRequest request) {
        return commodityService.updateInventoryByNumber(session, request);
    }

    @PostMapping(value = "update_commodity_price_by_number")
    public UpdateCommodityResponse updatePriceByNumber(HttpSession session, @RequestBody UpdateCommodityRequest request) {
        return commodityService.updatePriceByNumber(session, request);
    }

    @PostMapping(value = "distinctSearchCommodityByName")
    public DistinctSearchResponse distinctSearchCommodityByName(HttpSession session, @RequestBody SearchCommodityRequest request) {
        return commodityService.distinctSearchCommodityByName(session, request);
    }

    @PostMapping(value = "distinctSearchCommodityByCategory")
    public DistinctSearchResponse distinctSearchCommodityByCategory( @RequestBody SearchCommodityRequest request) {
        return commodityService.distinctSearchCommodityByCategory(request);
    }

    @PostMapping(value = "add_image")
    public AddCommodityResponse addImage(HttpSession session,@RequestBody AddImageRequest request) throws IOException{
        return commodityService.addImage(session,request);
    }

    @PostMapping(value = "search_com_by_name")
    public SearchCommodityResponse searchCommodityByName(@RequestBody SearchCommodityRequest request) {
    	return commodityService.searchCommodityByName(request);
    }
    
    @PostMapping(value = "find_CommodityForManage")
    public GetCommodityInfo findCommodityForManage(HttpSession session) {
    	return commodityService.findCommodityForManage(session);
    }
    
    @PostMapping(value = "search_com_by_number")
    public SearchCommodityResponse searchCommodityById(@RequestBody SearchCommodityRequest request) {
    	return commodityService.searchCommodityById( request);
    }

    // 0614 被嫌棄後新增的
    @PostMapping(value = "update_commodity")
    public UpdateCommodityResponse updateCommodity(HttpSession session,@RequestBody UpdateCommodityRequest request){
        return commodityService.updateCommodity(session,request);
    }
    // 0614 15:33 新增
    @GetMapping(value = "get_all_com")
    public UpdateCommodityResponse getAllCommodity() {
        return commodityService.getAllCommodity();
    }

    // 0615 15:00 新增
    @PostMapping(value = "search_com_by_name_or_category")
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory(@RequestBody SearchCommodityRequest request) {
        return commodityService.distinctSearchCommodityByNameOrCategory(request);
    }
    //0615新增
    @GetMapping(value = "get_4_commodity")
    public UpdateCommodityResponse searchTop4CommodityById() {
        return commodityService.searchTop4CommodityById();
    }
}
