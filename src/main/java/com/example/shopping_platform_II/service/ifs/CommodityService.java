package com.example.shopping_platform_II.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.noSoldCommodityResponse;

public interface CommodityService {
	// ���j ���� ��䛔 �ݔ䛔Numer������
	public addCommodityResponse listingProducts(HttpSession httpSession, List<Commodity> goods);
	
	public noSoldCommodityResponse noSoldProducts(HttpSession httpSession, int number);
}
