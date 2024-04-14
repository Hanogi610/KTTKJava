package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_for_sale",foreignKeys = {
		@ForeignKey(entity = Product.class, parentColumns = "id", childColumns = "product_id")
})
public class ProductForSale {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private String name;
	private double price;
	private String des;
	private String warehouse;
	private int remainInWarehouse;
	private int product_id;


	public ProductForSale(String name, double price, String des, String warehouse, int remainInWarehouse, int product_id) {
		this.name = name;
		this.price = price;
		this.des = des;
		this.warehouse = warehouse;
		this.remainInWarehouse = remainInWarehouse;
		this.product_id = product_id;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
}