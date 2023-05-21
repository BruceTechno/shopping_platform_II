package com.example.shopping_platform_II.vo;

public class UpdateRequest {
    private String account ;
    private String pwd;
    private String name;
    private String address;
    private String phone;
//==================================================================


    public UpdateRequest() {
    }

    public UpdateRequest(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }
    //==================================================================

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
