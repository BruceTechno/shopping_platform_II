package com.example.shopping_platform_II.vo;

import java.util.List;

import com.example.shopping_platform_II.entity.Commodity;

public class addCommodityRequest {
	
	private List<Commodity> reqCommodity;
	
	private int number;
	
	private String name;
	
	private String category;
	
	private int inventory;
	
	private int price;
	
	private int status;
	
	private int userId;
	
	

	public addCommodityRequest() {
		super();
	}

	public addCommodityRequest(int number, String name, String category, int inventory, int price, int status,
			int userId) {
		super();
		this.number = number;
		this.name = name;
		this.category = category;
		this.inventory = inventory;
		this.price = price;
		this.status = status;
		this.userId = userId;
	}
	
	

	public addCommodityRequest(List<Commodity> reqCommodity) {
		super();
		this.reqCommodity = reqCommodity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Commodity> getReqCommodity() {
		return reqCommodity;
	}

	public void setReqCommodity(List<Commodity> reqCommodity) {
		this.reqCommodity = reqCommodity;
	}
	
	
	
	
	
	
	
	

}
