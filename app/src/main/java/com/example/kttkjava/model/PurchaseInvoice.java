package com.example.kttkjava.model;

import java.util.Date;
import java.util.List;

public class PurchaseInvoice {

	private int id;
	private float total;
	private Date date;
	private List<PurchaseProduct> productList;
	private Payment payment;
	private Shipment shipment;
	private Supplier supplier;

	public PurchaseInvoice(int id, float total, Date date, List<PurchaseProduct> productList, Payment payment, Shipment shipment, Supplier supplier) {
		this.id = id;
		this.total = total;
		this.date = date;
		this.productList = productList;
		this.payment = payment;
		this.shipment = shipment;
		this.supplier = supplier;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<PurchaseProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<PurchaseProduct> productList) {
		this.productList = productList;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}