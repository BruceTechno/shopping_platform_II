package com.example.shopping_platform_II.vo;

import java.util.List;

public class DelCommodityFromCartRequest {
	
private int commodityNumber;
	
//	新增商品編號
	
	private List<Integer> number;
	
	
//	新增的
	
	public DelCommodityFromCartRequest(List<Integer> number) {
	super();
	this.number = number;
}


	public List<Integer> getNumber() {
		return number;
	}


	public void setNumber(List<Integer> number) {
		this.number = number;
	}


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
