package com.example.shopping_platform_II.constants;



public enum RtnCode {

	SUCCESSFUL("200", "Successful!!!"),
	DATALIST_EMPTY("400", "The commoditys list is Empty!!"),
	CONTENT_EMPTY("401", "The commoditys list is Empty!!"),
	
	NUMBER_ERROR("405", "Commodity NumberÅ@Overlap!");

	
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
