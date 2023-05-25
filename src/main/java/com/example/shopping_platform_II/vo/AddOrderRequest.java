package com.example.shopping_platform_II.vo;


import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddOrderRequest {

//	Map<Integer, Integer> orderInfo,int payWay , int deliveryWay
	@JsonProperty("students")
	private Map<Integer, Integer> orderInfo;
	
	@JsonProperty("students")
	private int payWay;
	
	@JsonProperty("students")
	private int deliveryWay;

	public Map<Integer, Integer> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Map<Integer, Integer> orderInfo) {
		this.orderInfo = orderInfo;
	}

	public int getPayWay() {
		return payWay;
	}

	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}

	public int getDeliveryWay() {
		return deliveryWay;
	}

	public void setDeliveryWay(int deliveryWay) {
		this.deliveryWay = deliveryWay;
	}
	
	
}
