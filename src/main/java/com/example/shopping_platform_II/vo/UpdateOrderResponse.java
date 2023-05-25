package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.Order;

public class UpdateOrderResponse {

	private String message;
	
	private Order newOrder;

	public UpdateOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateOrderResponse(String message) {
		super();
		this.message = message;
	}
	

	public UpdateOrderResponse(String message, Order newOrder) {
		super();
		this.message = message;
		this.newOrder = newOrder;
	}

	public Order getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
