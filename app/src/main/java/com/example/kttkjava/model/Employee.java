package com.example.kttkjava.model;

import java.util.Date;

public class Employee extends Person {

	private String position;
	private float salary;
	private Account account;

	public Employee(int id, Date dob, String gender, Name name, Address address, String position, float salary, Account account) {
		super(id,dob,gender,name,address);
		this.position = position;
		this.salary = salary;
		this.account = account;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}