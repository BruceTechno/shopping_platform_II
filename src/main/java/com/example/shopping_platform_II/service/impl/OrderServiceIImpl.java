package com.example.shopping_platform_II.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_platform_II.repository.OrderDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceIImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public void addOrder(int id, Map<String, Integer> orderInfo, int payWay, int deliveryWay) {
		
		//id check 
		if(!userDao.existsById(id)) {
			//TODO 
			//use session when log in can add order
			//return plz log in 
		}
		
		//order check
		if(orderInfo.size() <=  0) {
			//return the order can not empty		
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String orderInfoStr = mapper.writeValueAsString(orderInfo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int orderNumber = (int)Math.random()*1000;
		
		
		
		
		
		
		
		
	}

	
}
