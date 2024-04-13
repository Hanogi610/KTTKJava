package com.example.kttkjava.model;

public class InstallmentProduct {

	private int id;
	private double quantity;
	private String unit;
	private double amount;

	public InstallmentProduct(int id, double quantity, String unit, double amount) {
		this.id = id;
		this.quantity = quantity;
		this.unit = unit;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}