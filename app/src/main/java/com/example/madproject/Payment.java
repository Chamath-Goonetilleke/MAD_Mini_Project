package com.example.madproject;

public class Payment {
    private String uId;;
    private String imageURL;
    private String itemType;
    private int prices;
    private String itemId;
//    private String cNumber, address, total;


    public Payment() {
    }

    public Payment(String uId, String imageURL, String itemId, String itemType, int prices) {
        this.uId = uId;
        this.imageURL = imageURL;
        this.itemType = itemType;
        this.prices = prices;
        this.itemId = itemId;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String name) {
        this.uId = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int price) {
        this.prices = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
