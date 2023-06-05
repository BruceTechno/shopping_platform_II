package com.example.shopping_platform_II.vo;

public class DelCommodityFromCartRequest {

	private int commodityNumber;
	
	
	public DelCommodityFromCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public DelCommodityFromCartRequest(int commodityNumber) {
		super();
		this.commodityNumber = commodityNumber;
	}



	public int getCommodityNumber() {
		return commodityNumber;
	}


	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}


}
