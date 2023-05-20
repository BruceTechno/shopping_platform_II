package com.example.shopping_platform_II.service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteOderRequest {

	private String accountBuy;
	
	private String pwd;
	
	private int orderNumber;

	public String getAccountBuy() {
		return accountBuy;
	}

	public void setAccountBuy(String accountBuy) {
		this.accountBuy = accountBuy;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	

	
	
}
