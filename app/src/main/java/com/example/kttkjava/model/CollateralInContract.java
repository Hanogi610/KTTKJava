package com.example.kttkjava.model;

public class CollateralInContract {

	private int id;
	private double value;
	private String condition;

	public CollateralInContract(int id, double value, String condition) {
		this.id = id;
		this.value = value;
		this.condition = condition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
}