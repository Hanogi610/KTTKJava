package com.example.kttkjava.model;

public class Payment {

	private int id;
	private String name;
	private String des;
	private Employee e;

	public Payment(int id, String name, String des, Employee e) {
		this.id = id;
		this.name = name;
		this.des = des;
		this.e = e;
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

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}
}