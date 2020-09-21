package com.venaktesh.loan.model;

import java.util.Date;

public class Schedule {

	private Date paymentDate;
	private Double principal;
	private Double projectedInterest;
	private String paymentStatus;
	private Double paymentAmount;

	private Double startingBalance;
	private Double newBalance;

	public Schedule(Date paymentDate, Double principal, Double projectedInterest, String paymentStatus,
			Double paymentAmount, Double startingBalance, Double newBalance) {
		super();
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectedInterest = projectedInterest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
		this.startingBalance = startingBalance;
		this.newBalance = newBalance;
	}

	public Schedule() {

	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getProjectedInterest() {
		return projectedInterest;
	}

	public void setProjectedInterest(Double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Double getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(Double startingBalance) {
		this.startingBalance = startingBalance;
	}

	public Double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(Double newBalance) {
		this.newBalance = newBalance;
	}

	@Override
	public String toString() {
		return "Schedule [paymentDate=" + paymentDate + ", principal=" + principal + ", projectedInterest="
				+ projectedInterest + ", paymentStatus=" + paymentStatus + ", paymentAmount=" + paymentAmount
				+ ", startingBalance=" + startingBalance + ", newBalance=" + newBalance + "]";
	}

}
