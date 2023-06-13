package com.example.shopping_platform_II.vo;

public class AddImageRequest {
    private String img;

    private int commodityNumber ;

    private String message ;
 //==

    public AddImageRequest() {
    }
//==

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }
}
