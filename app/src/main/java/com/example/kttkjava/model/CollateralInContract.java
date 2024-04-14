package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "collateral_in_contract",foreignKeys = {@ForeignKey(entity = Collateral.class, parentColumns = "id", childColumns = "collateral_id", onDelete = ForeignKey.CASCADE),
		@ForeignKey(entity = InstallmentProductContract.class, parentColumns = "id", childColumns = "installment_product_contract_id", onDelete = ForeignKey.CASCADE)})
public class CollateralInContract {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private double value;
	private String condition;
	private int collateral_id;
	private int installment_product_contract_id;

	public CollateralInContract(double value, String condition, int collateral_id, int installment_product_contract_id) {
		this.value = value;
		this.condition = condition;
		this.collateral_id = collateral_id;
		this.installment_product_contract_id = installment_product_contract_id;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getCollateral_id() {
		return collateral_id;
	}

	public void setCollateral_id(int collateral_id) {
		this.collateral_id = collateral_id;
	}
}