package com.example.shopping_platform_II.constants;



public enum RtnCode {

    SUCCESSFUL("200","Successful!!"),
    CANNOT_EMPTY("400","Data is empty!!!"),
    DATA_ERROR("400","Data is error!!!"),
    DATA_DUPLICATE("400","Data is duplicate"),
    NOT_FOUND("404","Not found!!!"),



	CAN_NOT_DELETE("400","Order Can not Delete !"),

	INVENTORY_NOT_ENOUGH("400","Inventory not enough !"),
	ACCOUNT_PWD_ERROR("401","Account or password error !"),
	PLEASE_LOGIN_FIRST("400","Please Login First !");

    private String code;
    private String message;
//=======================================================================================

    RtnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    RtnCode() {
    }

    //========================================================================================

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
