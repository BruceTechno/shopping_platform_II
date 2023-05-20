package com.example.shopping_platform_II.service.ifs;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.service.vo.AddOrderResponse;
import com.example.shopping_platform_II.service.vo.DeleteOrderResponse;
import com.example.shopping_platform_II.service.vo.SearchOrderResponse;

public interface OrderService {
	
	public AddOrderResponse addOrder(HttpSession httpSession,Map<Integer, Integer> orderInfo,int payWay , int deliveryWay);
	
	public DeleteOrderResponse deleteOrder(HttpSession httpSession ,int orderNumber );
	
	public SearchOrderResponse searchOrderByAccountBuy(String account,String pwd);
	
	public SearchOrderResponse searchOrderByAccountsale(String account,String pwd);
}
