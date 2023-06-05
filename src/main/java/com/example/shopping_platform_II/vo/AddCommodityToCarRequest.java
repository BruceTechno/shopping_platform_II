package com.example.shopping_platform_II.vo;

public class AddCommodityToCarRequest {
	
	private int id;
	
	private String userId;
	
	private int commodityNumber;
	
	private int quantity;
	
	

	public AddCommodityToCarRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AddCommodityToCarRequest(String userId, int commodityNumber, int quantity) {
		super();
		this.userId = userId;
		this.commodityNumber = commodityNumber;
		this.quantity = quantity;
	}



	public AddCommodityToCarRequest(int id, String userId, int commodityNumber, int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.commodityNumber = commodityNumber;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getCommodityNumber() {
		return commodityNumber;
	}



	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	
	
	
	
	
}
