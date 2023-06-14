package com.example.shopping_platform_II.vo;

public class DeleteCommodityRequest {
	
	private int commodityNumber;

//-------------------------------------------------------------
	
	public DeleteCommodityRequest() {
		super();
	}
	
//--------------------------------------------------------------

	public DeleteCommodityRequest(int number) {
		super();
		this.commodityNumber = number;
	}

//--------------------------------------------------------------


	public int getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
}
