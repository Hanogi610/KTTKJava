package com.example.kttkjava.model;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "purchase_product",
		foreignKeys = {
				@ForeignKey(entity = Product.class, parentColumns = "id", childColumns = "product_id")
		},
		indices = {@Index(value = "id", unique = true)}
)
public class PurchaseProduct implements Serializable {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int product_id;
	private int quantity;
	private float cost;


	public PurchaseProduct(int product_id, int quantity, float cost) {
		this.product_id = product_id;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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