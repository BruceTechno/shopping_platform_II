package com.example.shopping_platform_II.vo;

import com.example.shopping_platform_II.entity.User;

public class GetUserResponse {
	
	private String message ;
	
	private User user ;

	public GetUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUserResponse(String message) {
		super();
		this.message = message;
	}

	public GetUserResponse(String message, User user) {
		super();
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
