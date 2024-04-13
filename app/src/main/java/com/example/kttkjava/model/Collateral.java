package com.example.kttkjava.model;

public class Collateral {

	private int id;
	private String type;
	private String name;
	private String value;
	private String condition;
	private Customer cus;

	public Collateral(int id, String type, String name, String value, String condition, Customer cus) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.value = value;
		this.condition = condition;
		this.cus = cus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}
}