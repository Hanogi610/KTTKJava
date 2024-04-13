package com.example.kttkjava.model;

public class Address {

	private int id;
	private String street;
	private String district;
	private String city;
	private String province;
	private String country;

	public Address(int id, String street, String district, String city, String province, String country) {
		this.id = id;
		this.street = street;
		this.district = district;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}