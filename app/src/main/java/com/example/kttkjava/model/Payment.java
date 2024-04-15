package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
		@ForeignKey(entity = Customer.class, parentColumns = "id", childColumns = "customer_id"),
		@ForeignKey(entity = LendingPartner.class, parentColumns = "id", childColumns = "lending_partner_id"),
		@ForeignKey(entity = InstallmentProductContract.class, parentColumns = "id", childColumns = "installment_product_contract_id")})
public class Payment {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private String name;
	private String des;
	private int customer_id;
	private int lending_partner_id;
	private int installment_product_contract_id;

	private float amount;


	public Payment(String name, String des, int customer_id, int lending_partner_id, int installment_product_contract_id, float amount) {
		this.name = name;
		this.des = des;
		this.customer_id = customer_id;
		this.amount = amount;
		this.lending_partner_id = lending_partner_id;
		this.installment_product_contract_id = installment_product_contract_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getLending_partner_id() {
		return lending_partner_id;
	}

	public void setLending_partner_id(int lending_partner_id) {
		this.lending_partner_id = lending_partner_id;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}