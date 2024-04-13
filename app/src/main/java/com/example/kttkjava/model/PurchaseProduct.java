package com.example.kttkjava.model;

public class PurchaseProduct {

	private int id;
	private Product product;
	private int quantity;
	private float cost;

	public PurchaseProduct(int id, Product product, int quantity, float cost) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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