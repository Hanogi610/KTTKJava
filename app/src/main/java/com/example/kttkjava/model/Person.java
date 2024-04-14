package com.example.kttkjava.model;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.kttkjava.model.Address;
import com.example.kttkjava.model.Name;

import java.util.Date;

@Entity(foreignKeys = {
		@ForeignKey(entity = Name.class,
				parentColumns = "id",
				childColumns = "name_id",
				onDelete = ForeignKey.CASCADE),
		@ForeignKey(entity = Address.class,
				parentColumns = "id",
				childColumns = "address_id",
				onDelete = ForeignKey.CASCADE)
})
public class Person {
	@PrimaryKey
	private int id;
	private String dob;
	private String gender;
	private int name_id;
	private int address_id;


	public Person(int id, String dob, String gender, int name_id, int address_id) {
		this.id = id;
		this.dob = dob;
		this.gender = gender;
		this.name_id = name_id;
		this.address_id = address_id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getName_id() {
		return name_id;
	}

	public void setName_id(int name_id) {
		this.name_id = name_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
}
