package com.example.kttkjava.model;

public class ProductForSale {

	private int id;
	private String name;
	private double price;
	private String des;
	private String warehouse;
	private int remainInWarehouse;
	private Product product;

	public ProductForSale(int id, String name, double price, String des, String warehouse, int remainInWarehouse, Product product) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.des = des;
		this.warehouse = warehouse;
		this.remainInWarehouse = remainInWarehouse;
		this.product = product;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public int getRemainInWarehouse() {
		return remainInWarehouse;
	}

	public void setRemainInWarehouse(int remainInWarehouse) {
		this.remainInWarehouse = remainInWarehouse;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}