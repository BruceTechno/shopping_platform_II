package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.*;

import java.util.List;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface CommodityService {
    public AddCommodityResponse addCommodity (HttpSession session, AddCommodityRequest request);
    public AddCommodityResponse addImage (HttpSession session, AddImageRequest request) throws IOException;
    public DeleteCommodityResponse deleteCommodity(HttpSession session , DeleteCommodityRequest request);
    public UpdateCommodityResponse updateNameByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updateCategoryByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updateInventoryByNumber(HttpSession session , UpdateCommodityRequest request);
    public UpdateCommodityResponse updatePriceByNumber(HttpSession session , UpdateCommodityRequest request);
    public SearchCommodityResponse searchCommodityByName(SearchCommodityRequest request);
    public SearchCommodityResponse searchCommodityByCategory(HttpSession session,SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByName (HttpSession session,SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByCategory (SearchCommodityRequest request);
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory (HttpSession session,SearchCommodityRequest request);
    public SearchCommodityResponse searchCommodityById(HttpSession session,SearchCommodityRequest request);
    public GetCommodityInfo findCommodityForManage (HttpSession session);

    public UpdateCommodityResponse updateCommodity(HttpSession session , UpdateCommodityRequest request);

    public UpdateCommodityResponse getAllCommodity ();
}
