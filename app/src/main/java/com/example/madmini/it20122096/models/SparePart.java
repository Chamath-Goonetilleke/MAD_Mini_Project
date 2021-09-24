package com.example.madmini.it20122096.models;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

// TODO: by Dasun
public class SparePart implements Serializable {

    // attributes
    @Exclude
    private String key;
    private String name;
    private String brand;
    private String model;
    private double unitPrice;
    private String desc;

    // default constructor
    public SparePart() {
    }

    // overload constructor
    public SparePart(String name, String brand, String model, double unitPrice, String desc) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.unitPrice = unitPrice;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
