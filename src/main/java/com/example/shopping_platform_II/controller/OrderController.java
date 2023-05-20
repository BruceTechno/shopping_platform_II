package com.example.shopping_platform_II.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.service.vo.AddOrderRequest;
import com.example.shopping_platform_II.service.vo.AddOrderResponse;
import com.example.shopping_platform_II.service.vo.DeleteOderRequest;
import com.example.shopping_platform_II.service.vo.DeleteOrderResponse;
import com.example.shopping_platform_II.service.vo.SearchOrderResponse;
import com.example.shopping_platform_II.service.vo.UpdateOrderResponse;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "add_order")
	public AddOrderResponse addOrder(@RequestBody AddOrderRequest request, HttpSession httpSession) {
		return orderService.addOrder(httpSession, request.getOrderInfo(), request.getPayWay(),
				request.getDeliveryWay());
	}

	@PostMapping(value = "delete_order")
	public DeleteOrderResponse deleteOrder(@RequestBody DeleteOderRequest request, HttpSession httpSession) {
		return orderService.deleteOrder(httpSession, request.getOrderNumber());
	}

	@PostMapping(value = "search_order_by_account_buy")
	public SearchOrderResponse searchOrderByAccountBuy(HttpSession httpSession) {
		return orderService.searchOrderByAccountBuy(httpSession);
	}

	@PostMapping(value = "search_order_by_account_sale")
	public SearchOrderResponse searchOrderByAccountsale(HttpSession httpSession) {
		return orderService.searchOrderByAccountSale(httpSession);
	}
	
	@PostMapping(value = "update_order")
	public UpdateOrderResponse updateOrder(HttpSession httpSession ,
			int orderNumber , Map<Integer, Integer> orderInfos) {
		return orderService.updateOrder(httpSession, orderNumber, orderInfos);
	}

}
