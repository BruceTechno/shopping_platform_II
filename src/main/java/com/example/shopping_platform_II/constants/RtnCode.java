package com.example.shopping_platform_II.constants;



public enum RtnCode {

	SUCCESSFUL("200", "Successful!!!"),
	CONTENT_EMPTY("400", "The commoditys list is Empty!!"),
	NO_NUM_GOODS_LIST("401", "Can't find the number in the commoditys list!!"),
	NUMBER_ERROR("405", "Commodity NumberÅ@Overlap!!"),
	PLEASE_LOGIN("402", "Please Login first!!"),
	ACCOUNT_PWD_ERROR("403", "The account and pwd is wrong!!"),
	
	CAN_NOT_DELETE("407", "Can't delete the number!!"),
	
	NUMBER_EMPTY("406", "Insert Commodity NumberÅ@Empty!!");
	

	
	private String code;
	
	private String message;
	
	

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
