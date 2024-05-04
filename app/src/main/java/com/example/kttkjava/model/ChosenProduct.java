package com.example.kttkjava.model;

import java.io.Serializable;

public class ChosenProduct implements Serializable {
    private int product_id;
    private String name;
    private String des;
    private float buyPrice;
    private int quantity;
    private float cost;

    public ChosenProduct(int product_id, String name, String des, float buyPrice, int quantity, float cost) {
        this.product_id = product_id;
        this.name = name;
        this.des = des;
        this.buyPrice = buyPrice;
        this.quantity = quantity;
        this.cost = cost;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
