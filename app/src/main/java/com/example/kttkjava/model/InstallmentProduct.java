package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "installment_product",foreignKeys = {
		@ForeignKey(entity = Product.class, parentColumns = "id", childColumns = "product_id"),
		@ForeignKey(entity = InstallmentProductContract.class, parentColumns = "id", childColumns = "installment_product_contract_id")})
public class InstallmentProduct {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private double quantity;
	private String unit;
	private double amount;
	private int product_id;
	private int installment_product_contract_id;


	public InstallmentProduct(double quantity, String unit, double amount, int product_id, int installment_product_contract_id) {
		this.quantity = quantity;
		this.unit = unit;
		this.amount = amount;
		this.product_id = product_id;
		this.installment_product_contract_id = installment_product_contract_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getInstallment_product_contract_id() {
		return installment_product_contract_id;
	}

	public void setInstallment_product_contract_id(int installment_product_contract_id) {
		this.installment_product_contract_id = installment_product_contract_id;
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

	public int getProduct_id() {
		return product_id;
	}
}