package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

import javax.servlet.http.HttpSession;

public interface ShoppingCarService {
	
//	新增既有商品至購物車
	
	public AddCommodityToCarResponse addCommodityToCar (HttpSession httpSession, AddCommodityToCarRequest request);
	
//  從購物車刪除已放的商品 （全選或特別選）跳出警示視窗
	
	public DelCommodityFromCartResponse deleCommodityFromCart (HttpSession httpSession,DelCommodityFromCartRequest request);
	
//  修改購物車內容 （修改數量）
	
	public UpdateInfoFromCartResponse updateInfoFromCart (HttpSession httpSession, UpdateInfoFromCartRequest request);
	
//  查詢購物車內容
	
    public GetShoppingCarResponse getShoppingCarInfo (HttpSession session);

}
