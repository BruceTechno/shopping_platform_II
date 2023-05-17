package com.example.shopping_platform_II.constants;



public enum RtnCode {
	
	SUCCESSFUL("200","Successful !"),
	CANNOT_EMPTY("400","OrderInfo can not empty!!"),
	DATA_ERROR("400","Data is error!!"),
	NOT_FOUND("404","Not found"),
	FILE_EXISTS("400","File is exists!"),
	ERROR("400","Error  ! "),
	PLEASE_LOGIN_FIRST("403","Please Login First !");
	
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
