package com.example.shopping_platform_II.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_car")
public class ShoppingCar {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "commodity_number")
    private int commodityNumber;
    @Column(name = "quantity")
    private int quantity;
//====================================================================================

    public ShoppingCar() {
    }
//====================================================================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(int commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
