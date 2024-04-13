package com.example.kttkjava.model;

public class Product {

	private int id;
	private String name;
	private String des;
	private float buyPrice;

	public Product(int id, String name, String des, float buyPrice) {
		this.id = id;
		this.name = name;
		this.des = des;
		this.buyPrice = buyPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}