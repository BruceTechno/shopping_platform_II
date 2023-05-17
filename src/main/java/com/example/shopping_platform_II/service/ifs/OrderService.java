package com.example.shopping_platform_II.service.ifs;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.service.vo.AddOrderResponse;

public interface OrderService {
	
	public AddOrderResponse addOrder(HttpSession httpSession,Map<Integer, Integer> orderInfo,int payWay , int deliveryWay);
	
	public void deleteOrder();
}
