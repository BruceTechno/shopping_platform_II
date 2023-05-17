package com.example.shopping_platform_II.service.ifs;

import java.util.Map;

public interface OrderService {
	
	public void addOrder(int id,Map<String, Integer> orderInfo,int payWay , int deliveryWay);
}
