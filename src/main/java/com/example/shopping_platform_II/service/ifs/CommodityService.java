package com.example.shopping_platform_II.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.deleteCommodityResponse;

public interface CommodityService {
	// ’ åj –§áù æ”ä›” Ä”ä›”Numer“™ŠŒ
	public addCommodityResponse listingProducts(HttpSession httpSession, List<Commodity> goods);
	
	// method: ‰º‰Ë¤•i(™ˆœšd•M)
	public deleteCommodityResponse noSoldProducts(HttpSession httpSession, int number);
}
