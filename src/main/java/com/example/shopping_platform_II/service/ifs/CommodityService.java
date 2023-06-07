package com.example.shopping_platform_II.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.deleteCommodityResponse;

public interface CommodityService {
	//  εj §αω ζδ ΔδNumer
	public addCommodityResponse listingProducts(HttpSession httpSession, List<Commodity> goods);
	
	// method: ΊΛ€i(dM)
	public deleteCommodityResponse noSoldProducts(HttpSession httpSession, int number);
}
