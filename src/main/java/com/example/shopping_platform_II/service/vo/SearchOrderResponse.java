package com.example.shopping_platform_II.service.vo;

import java.util.List;


import com.example.shopping_platform_II.entity.Order;

public class SearchOrderResponse {
	
	private String message;
	
	private List<Order> orderInfos;

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
