package com.venaktesh.loan;

import java.util.Date;

public class Loan {
//	@Id
	private String id;
	
	private String frequency;
	private String loanAmount;
	private Double intrestRate;
	private Date tradeDate;
	private Date loanStartDate;
	private int term;
	private boolean isExist;
	private int custID;
	private String matric;
	private Date matureDate;
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Date getLoanStartDate() {
		return loanStartDate;
	}
	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public boolean isExist() {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getMatric() {
		return matric;
	}
	public void setMatric(String matric) {
		this.matric = matric;
	}
	public Date getMatureDate() {
		return matureDate;
	}
	public void setMatureDate(Date matureDate) {
		this.matureDate = matureDate;
	}
	@Override
	public String toString() {
		return "loan [id=" + id + ", frequency=" + frequency + ", loanAmount=" + loanAmount + ", intrestRate="
				+ intrestRate + ", tradeDate=" + tradeDate + ", loanStartDate=" + loanStartDate + ", term=" + term
				+ ", isExist=" + isExist + ", custID=" + custID + ", matric=" + matric + ", matureDate=" + matureDate
				+ "]";
	}
	public Loan(String id, String frequency, String loanAmount, Double intrestRate, Date tradeDate, Date loanStartDate,
			int term, boolean isExist, int custID, String matric, Date matureDate) {
		super();
		this.id = id;
		this.frequency = frequency;
		this.loanAmount = loanAmount;
		this.intrestRate = intrestRate;
		this.tradeDate = tradeDate;
		this.loanStartDate = loanStartDate;
		this.term = term;
		this.isExist = isExist;
		this.custID = custID;
		this.matric = matric;
		this.matureDate = matureDate;
	}

}
