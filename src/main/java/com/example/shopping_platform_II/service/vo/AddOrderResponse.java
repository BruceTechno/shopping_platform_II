package com.example.shopping_platform_II.service.vo;

import java.util.Map;

public class AddOrderResponse {
	
	private String message;
	
	private Map<Integer, Integer> iteMap;

	public AddOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddOrderResponse(String message) {
		super();
		this.message = message;
	}

	public AddOrderResponse(String message, Map<Integer, Integer> iteMap) {
		super();
		this.message = message;
		this.iteMap = iteMap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<Integer, Integer> getIteMap() {
		return iteMap;
	}

	public void setIteMap(Map<Integer, Integer> iteMap) {
		this.iteMap = iteMap;
	}
	
	

}
