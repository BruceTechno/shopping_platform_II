package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

import javax.servlet.http.HttpSession;

public interface CommodityService {
    public AddCommodityResponse addCommodity (HttpSession session, AddCommodityRequest request);
    public DeleteCommodityResponse deleteCommodity(HttpSession session , DeleteCommodityRequest request);
    public UpdateCommodityResponse updateNameByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updateCategoryByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updateInventoryByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updatePriceByNumber(HttpSession session , UpdateCommodityRequest request);
    public SearchCommodityResponse searchCommodityByName(HttpSession session,SearchCommodityRequest request);
    public SearchCommodityResponse searchCommodityByCategory(HttpSession session,SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByName (HttpSession session,SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByCategory (HttpSession session,SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory (HttpSession session,SearchCommodityRequest request);

}
