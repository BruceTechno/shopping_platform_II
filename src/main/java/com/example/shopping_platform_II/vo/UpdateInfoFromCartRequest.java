package com.example.shopping_platform_II.vo;

public class UpdateInfoFromCartRequest {
	
	private String userId;
	
	private int commodityNumber;
	
	private int quantity;
	

	public UpdateInfoFromCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public UpdateInfoFromCartRequest(int quantity,String userId, int commodityNumber) {
		super();
		this.userId = userId;
		this.commodityNumber = commodityNumber;
		this.quantity = quantity;
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
