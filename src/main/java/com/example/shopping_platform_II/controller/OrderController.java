package com.example.shopping_platform_II.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.service.vo.AddOrderRequest;
import com.example.shopping_platform_II.service.vo.AddOrderResponse;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "add_Class")
	public AddOrderResponse addOrder(@RequestBody AddOrderRequest request,HttpSession httpSession) {
		return orderService.addOrder(httpSession, request.getOrderInfo(), request.getPayWay(), request.getDeliveryWay());
	}
	
	

}
