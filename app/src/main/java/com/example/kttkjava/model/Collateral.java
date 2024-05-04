package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "collateral",foreignKeys = @ForeignKey(entity = Customer.class, parentColumns = "id", childColumns = "customer_id", onDelete = ForeignKey.CASCADE))
public class Collateral {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private String type;
	private String name;
	private String value;
	private String condition;
	private int customer_id;

	public Collateral(String type, String name, String value, String condition, int customer_id) {
		this.type = type;
		this.name = name;
		this.value = value;
		this.condition = condition;
		this.customer_id = customer_id;
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
}