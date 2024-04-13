package com.example.kttkjava.model;

import java.util.Date;
import java.util.List;

public class InstallmentProductContract {

	private int id;
	private double totalAmount;
	private double amountRemaining;
	private double penaltyRate;
	private Date createDate;
	private String createAddress;
	private Date firstDatePaid;
	private double amountPaidEachCycle;
	private String dayPaidPerCycle;
	private String status;
	private Customer cus;
	private LendingPartner lendingPartner;
	private List<Payment> payments;
	private int maximumDayOutstanding;
	private List<InstallmentProduct> productList;
	private List<CollateralInContract> collateralList;
	private LendingPartner lp;

	public InstallmentProductContract(int id, double totalAmount, double amountRemaining, double penaltyRate, Date createDate, String createAddress, Date firstDatePaid, double amountPaidEachCycle, String dayPaidPerCycle, String status, Customer cus, LendingPartner lendingPartner, List<Payment> payments, int maximumDayOutstanding, List<InstallmentProduct> productList, List<CollateralInContract> collateralList, LendingPartner lp) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.amountRemaining = amountRemaining;
		this.penaltyRate = penaltyRate;
		this.createDate = createDate;
		this.createAddress = createAddress;
		this.firstDatePaid = firstDatePaid;
		this.amountPaidEachCycle = amountPaidEachCycle;
		this.dayPaidPerCycle = dayPaidPerCycle;
		this.status = status;
		this.cus = cus;
		this.lendingPartner = lendingPartner;
		this.payments = payments;
		this.maximumDayOutstanding = maximumDayOutstanding;
		this.productList = productList;
		this.collateralList = collateralList;
		this.lp = lp;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateAddress() {
		return createAddress;
	}

	public void setCreateAddress(String createAddress) {
		this.createAddress = createAddress;
	}

	public Date getFirstDatePaid() {
		return firstDatePaid;
	}

	public void setFirstDatePaid(Date firstDatePaid) {
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

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public LendingPartner getLendingPartner() {
		return lendingPartner;
	}

	public void setLendingPartner(LendingPartner lendingPartner) {
		this.lendingPartner = lendingPartner;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public int getMaximumDayOutstanding() {
		return maximumDayOutstanding;
	}

	public void setMaximumDayOutstanding(int maximumDayOutstanding) {
		this.maximumDayOutstanding = maximumDayOutstanding;
	}

	public List<InstallmentProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<InstallmentProduct> productList) {
		this.productList = productList;
	}

	public List<CollateralInContract> getCollateralList() {
		return collateralList;
	}

	public void setCollateralList(List<CollateralInContract> collateralList) {
		this.collateralList = collateralList;
	}

	public LendingPartner getLp() {
		return lp;
	}

	public void setLp(LendingPartner lp) {
		this.lp = lp;
	}
}