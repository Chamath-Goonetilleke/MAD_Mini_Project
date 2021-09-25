package com.example.madproject;

import java.io.Serializable;

public class Order implements Serializable {

    private String id;
    private String uId;
    private int price;
    private String itemType;


    public Order() {
    }

    public Order(String id, String uId, int price, String itemType) {
        this.id = id;
        this.uId = uId;
        this.price = price;
        this.itemType = itemType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
