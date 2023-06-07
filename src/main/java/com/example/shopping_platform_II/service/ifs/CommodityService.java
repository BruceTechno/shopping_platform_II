package com.example.shopping_platform_II.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.deleteCommodityResponse;

public interface CommodityService {
	// ���j ���� ��䛔 �Ĕ䛔Numer������
	public addCommodityResponse listingProducts(HttpSession httpSession, List<Commodity> goods);
	
	// method: ���ˏ��i(�����d�M)
	public deleteCommodityResponse noSoldProducts(HttpSession httpSession, int number);
}
