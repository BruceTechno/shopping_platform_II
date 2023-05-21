package com.example.shopping_platform_II.vo;

public class LoginRequest {
    private String account;

    private String pwd;

//======================================================


    public LoginRequest() {
    }
//======================================================

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
