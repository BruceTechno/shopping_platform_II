package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.Order;

import java.util.List;

public class SearchOrderResponse {
	
	private String message;
	
	private List<Order> orderInfos;
	private Order order;

	public SearchOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchOrderResponse(String message) {
		super();
		this.message = message;
	}

	public SearchOrderResponse(String message, List<Order> orderInfos) {
		super();
		this.message = message;
		this.orderInfos = orderInfos;
	}

	public SearchOrderResponse(String message, Order order) {
		super();
		this.message = message;
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Order> getOrderInfos() {
		return orderInfos;
	}

	public void setOrderInfos(List<Order> orderInfos) {
		this.orderInfos = orderInfos;
	}
	
	
	
	

}
