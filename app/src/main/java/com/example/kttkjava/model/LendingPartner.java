package com.example.kttkjava.model;

import java.util.Date;

public class LendingPartner extends Person {

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LendingPartner(int id, Date dob, String gender, Name name, Address address, String companyName) {
		super(id,dob,gender,name,address);
		this.companyName = companyName;
	}
}