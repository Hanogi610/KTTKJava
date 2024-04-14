package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import com.example.kttkjava.controller.Converter;

import java.util.Date;
import java.util.List;

@Entity(tableName = "installment_product_contract",foreignKeys = {
		@ForeignKey(entity = Customer.class, parentColumns = "id", childColumns = "customer_id"),
		@ForeignKey(entity = LendingPartner.class, parentColumns = "id", childColumns = "lending_partner_id")})
public class InstallmentProductContract {


	@PrimaryKey(autoGenerate = true)
	private int id;
	private double totalAmount;
	private double amountRemaining;
	private double penaltyRate;
	private String createDate;
	private String createAddress;
	private String firstDatePaid;
	private double amountPaidEachCycle;
	private String dayPaidPerCycle;
	private String status;

	// Foreign keys
	private int customer_id; // Foreign key to Customer
	private int lending_partner_id;

	public InstallmentProductContract(double totalAmount, double amountRemaining, double penaltyRate, String createDate, String createAddress, String firstDatePaid, double amountPaidEachCycle, String dayPaidPerCycle, String status, int customer_id, int lending_partner_id) {
		this.totalAmount = totalAmount;
		this.amountRemaining = amountRemaining;
		this.penaltyRate = penaltyRate;
		this.createDate = createDate;
		this.createAddress = createAddress;
		this.firstDatePaid = firstDatePaid;
		this.amountPaidEachCycle = amountPaidEachCycle;
		this.dayPaidPerCycle = dayPaidPerCycle;
		this.status = status;
		this.customer_id = customer_id;
		this.lending_partner_id = lending_partner_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(double amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public double getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateAddress() {
		return createAddress;
	}

	public void setCreateAddress(String createAddress) {
		this.createAddress = createAddress;
	}

	public String getFirstDatePaid() {
		return firstDatePaid;
	}

	public void setFirstDatePaid(String firstDatePaid) {
		this.firstDatePaid = firstDatePaid;
	}

	public double getAmountPaidEachCycle() {
		return amountPaidEachCycle;
	}

	public void setAmountPaidEachCycle(double amountPaidEachCycle) {
		this.amountPaidEachCycle = amountPaidEachCycle;
	}

	public String getDayPaidPerCycle() {
		return dayPaidPerCycle;
	}

	public void setDayPaidPerCycle(String dayPaidPerCycle) {
		this.dayPaidPerCycle = dayPaidPerCycle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}