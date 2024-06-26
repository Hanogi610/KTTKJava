package com.example.kttkjava.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "purchase_invoice",foreignKeys = {
		@ForeignKey(entity = Supplier.class, parentColumns = "id", childColumns = "supplier_id"),
		@ForeignKey(entity = Shipment.class, parentColumns = "id", childColumns = "shipment_id"),
		@ForeignKey(entity = Employee.class, parentColumns = "id", childColumns = "employee_id")})
public class PurchaseInvoice {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private float total;
	private String date;
	private int supplier_id;
	private int shipment_id;
	private int employee_id;


	public PurchaseInvoice(float total, String date, int supplier_id, int shipment_id, int employee_id) {
		this.total = total;
		this.date = date;
		this.supplier_id = supplier_id;
		this.shipment_id = shipment_id;
		this.employee_id = employee_id;
	}

	public int getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
}