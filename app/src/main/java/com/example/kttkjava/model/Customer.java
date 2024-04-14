package com.example.kttkjava.model;

import androidx.room.Entity;

import java.util.Date;
@Entity

public class Customer extends Person {

	private String job;
	private String workPlace;
	private double totalAmount;
	private double totalRemaining;
	private int totalContract;

	public Customer(int id, String dob, String gender, int name_id, int address_id, String job, String workPlace, double totalAmount, double totalRemaining, int totalContract) {
		super(id, dob, gender, name_id, address_id);
		this.job = job;
		this.workPlace = workPlace;
		this.totalAmount = totalAmount;
		this.totalRemaining = totalRemaining;
		this.totalContract = totalContract;
	}


	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalRemaining() {
		return totalRemaining;
	}

	public void setTotalRemaining(double totalRemaining) {
		this.totalRemaining = totalRemaining;
	}

	public int getTotalContract() {
		return totalContract;
	}

	public void setTotalContract(int totalContract) {
		this.totalContract = totalContract;
	}
}