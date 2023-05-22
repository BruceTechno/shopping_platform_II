package com.example.shopping_platform_II.service.ifs;

import java.util.List;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.addCommodityResponse;

public interface CommodityService {
	
	public addCommodityResponse listingProducts(List<Commodity> goods);
}
