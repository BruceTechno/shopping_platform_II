package com.example.shopping_platform_II.service.ifs;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.shopping_platform_II.entity.Order;
import com.example.shopping_platform_II.vo.AddOrderResponse;
import com.example.shopping_platform_II.vo.DeleteOrderResponse;
import com.example.shopping_platform_II.vo.SearchOrderResponse;
import com.example.shopping_platform_II.vo.UpdateOrderResponse;

public interface OrderService {
	
	public AddOrderResponse addOrder(HttpSession httpSession,Map<Integer, Integer> orderInfo,int payWay , int deliveryWay);
	
	public DeleteOrderResponse deleteOrder(HttpSession httpSession ,int orderNumber );
	
	public SearchOrderResponse searchOrderByAccountBuy(HttpSession httpSession);
	
	public SearchOrderResponse searchOrderByAccountSale(HttpSession httpSession);
	
	public UpdateOrderResponse updateOrder(HttpSession httpSession , int orderNumber , Map<Integer, Integer> orderInfos);
	
	public SearchOrderResponse searchOrderByOrderNumber(HttpSession httpSession , int orderNumber);
}
