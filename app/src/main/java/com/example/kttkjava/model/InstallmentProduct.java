package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "installment_product",foreignKeys = {
		@ForeignKey(entity = ProductForSale.class, parentColumns = "id", childColumns = "product_for_sale_id"),
		@ForeignKey(entity = InstallmentProductContract.class, parentColumns = "id", childColumns = "intallmaent_product_contract_id")})
public class InstallmentProduct {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private double quantity;
	private String unit;
	private double amount;
	private int product_for_sale_id;
	private int intallmaent_product_contract_id;


	public InstallmentProduct(double quantity, String unit, double amount, int product_for_sale_id, int intallmaent_product_contract_id) {
		this.quantity = quantity;
		this.unit = unit;
		this.amount = amount;
		this.product_for_sale_id = product_for_sale_id;
		this.intallmaent_product_contract_id = intallmaent_product_contract_id;
	}

	public int getProduct_for_sale_id() {
		return product_for_sale_id;
	}

	public void setProduct_for_sale_id(int product_for_sale_id) {
		this.product_for_sale_id = product_for_sale_id;
	}

	public int getIntallmaent_product_contract_id() {
		return intallmaent_product_contract_id;
	}

	public void setIntallmaent_product_contract_id(int intallmaent_product_contract_id) {
		this.intallmaent_product_contract_id = intallmaent_product_contract_id;
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