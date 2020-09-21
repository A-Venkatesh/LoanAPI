package com.venaktesh.loan.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scheduleSheet")
public class ScheduleSheet {
	@Id
	private String loanID;
	private List<Schedule> evenPrincipal = new ArrayList<Schedule>();
	private List<Schedule> interestOnly = new ArrayList<Schedule>();
	int custID;

	public ScheduleSheet() {
	}

	public List<Schedule> getEvenPrincipal() {
		return evenPrincipal;
	}

	public void setEvenPrincipal(List<Schedule> evenPrincipal) {
		this.evenPrincipal = evenPrincipal;
	}

	public List<Schedule> getInterestOnly() {
		return interestOnly;
	}

	public void setInterestOnly(List<Schedule> interestOnly) {
		this.interestOnly = interestOnly;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getLoanID() {
		return loanID;
	}

	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

}
