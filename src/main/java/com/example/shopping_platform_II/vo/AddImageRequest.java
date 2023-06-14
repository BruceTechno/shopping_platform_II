package com.example.shopping_platform_II.vo;

public class AddImageRequest {
    private String img;

    private int commodityNumber ;

    private String account;

 //==

    public AddImageRequest() {
    }
//==

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }
}
