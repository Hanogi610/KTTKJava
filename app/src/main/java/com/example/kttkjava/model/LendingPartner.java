package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "lending_partner")
public class LendingPartner extends Person {

	private String companyName;

	public LendingPartner(int id, String dob, String gender, int name_id, int address_id, String companyName) {
		super(id, dob, gender, name_id, address_id);
		this.companyName = companyName;
	}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



}