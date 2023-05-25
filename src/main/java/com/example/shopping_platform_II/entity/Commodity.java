package com.example.shopping_platform_II.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "commodity")
public class Commodity {
    @Id
    @Column(name = "number")
    private int number ;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "inventory")
    private int inventory;
    @Column(name = "price")
    private int price;
    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();
    @Column(name = "account_sell")
    private String accountSell;
//========================================================================================================

    public Commodity() {
    }
//========================================================================================================

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAccountSell() {
		return accountSell;
	}

	public void setAccountSell(String accountSell) {
		this.accountSell = accountSell;
	}

    

   
}
