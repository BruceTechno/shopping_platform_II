package com.example.shopping_platform_II.vo;

public class CommodityResponse {

	private addCommodityResponse addProduct;
	
	private noSoldCommodityResponse noSoldProduct;

	private String message;
	
	
	public CommodityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	public CommodityResponse(String message) {
		super();
		this.message = message;
	}



	public CommodityResponse(addCommodityResponse addProduct) {
		super();
		this.addProduct = addProduct;
	}

	
	
	public CommodityResponse(noSoldCommodityResponse noSoldProduct) {
		super();
		this.noSoldProduct = noSoldProduct;
	}



	public addCommodityResponse getAddProduct() {
		return addProduct;
	}

	public void setAddProduct(addCommodityResponse addProduct) {
		this.addProduct = addProduct;
	}

	public noSoldCommodityResponse getNoSoldProduct() {
		return noSoldProduct;
	}

	public void setNoSoldProduct(noSoldCommodityResponse noSoldProduct) {
		this.noSoldProduct = noSoldProduct;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
