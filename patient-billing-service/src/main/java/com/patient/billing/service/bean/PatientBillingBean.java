package com.patient.billing.service.bean;
import java.time.LocalDate;

public class PatientBillingBean {
	private int billId;
	private LocalDate billingDate;
	private int bedAllocationId;
//	private int patitentId;
	private String patitentFristName;
	private String patitentLastName;
//	private String roomTypeName;
	private double paidAmount;
	private double discount;
	private double totalAmount;
	private String paymentStatus;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public int getBedAllocationId() {
		return bedAllocationId;
	}
	public void setBedAllocationId(int bedAllocationId) {
		this.bedAllocationId = bedAllocationId;
	}
	public String getPatitentFristName() {
		return patitentFristName;
	}
	public void setPatitentFristName(String patitentFristName) {
		this.patitentFristName = patitentFristName;
	}
	public String getPatitentLastName() {
		return patitentLastName;
	}
	public void setPatitentLastName(String patitentLastName) {
		this.patitentLastName = patitentLastName;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public PatientBillingBean(int billId, LocalDate billingDate, int bedAllocationId, String patitentFristName,
			String patitentLastName, double paidAmount, double discount, double totalAmount, String paymentStatus) {
		super();
		this.billId = billId;
		this.billingDate = billingDate;
		this.bedAllocationId = bedAllocationId;
		this.patitentFristName = patitentFristName;
		this.patitentLastName = patitentLastName;
		this.paidAmount = paidAmount;
		this.discount = discount;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
	}
	public PatientBillingBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		

}
