package com.example.kttkjava.model;

import java.util.Date;

public class Person {

	private int id;
	private Date dob;
	private String gender;
	private Name name;
	private Address address;

	public Person(int id, Date dob, String gender, Name name, Address address) {
		this.id = id;
		this.dob = dob;
		this.gender = gender;
		this.name = name;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}