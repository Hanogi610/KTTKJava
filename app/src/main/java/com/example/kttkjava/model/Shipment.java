package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "shipment")
public class Shipment implements Serializable {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private String name;
	private String des;



	public Shipment(String name, String des) {
		this.name = name;
		this.des = des;
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
}