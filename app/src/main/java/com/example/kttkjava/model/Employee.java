package com.example.kttkjava.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "employee",foreignKeys = @ForeignKey(entity = Account.class,
		parentColumns = "id",
		childColumns = "account_id",
		onDelete = ForeignKey.CASCADE))
public class Employee extends Person {


	private String position;
	private float salary;
	private int account_id;


	public Employee(int id, String dob, String gender, int name_id, int address_id, String position, float salary, int account_id) {
		super(id, dob, gender, name_id, address_id);
		this.position = position;
		this.salary = salary;
		this.account_id = account_id;
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

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
}