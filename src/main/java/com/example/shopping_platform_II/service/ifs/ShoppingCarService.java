package com.example.shopping_platform_II.service.ifs;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.vo.AddCommodityToCarRequest;
import com.example.shopping_platform_II.vo.AddCommodityToCarResponse;
import com.example.shopping_platform_II.vo.DelCommodityFromCartRequest;
import com.example.shopping_platform_II.vo.DelCommodityFromCartResponse;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartRequest;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartResponse;

public interface ShoppingCarService {
	
//	新增既有商品至購物車
	
	public AddCommodityToCarResponse addCommodityToCar (HttpSession httpSession, AddCommodityToCarRequest request);
	
//  從購物車刪除已放的商品 （全選或特別選）跳出警示視窗
	
	public DelCommodityFromCartResponse deleCommodityFromCart (HttpSession httpSession,DelCommodityFromCartRequest request);
	
//  修改購物車內容 （修改數量）
	
	public UpdateInfoFromCartResponse updateInfoFromCart (HttpSession httpSession, UpdateInfoFromCartRequest request);
	
//  查詢購物車內容
	
//  將購物車選取的內容前往結賬並回傳至訂單
}
