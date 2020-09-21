package com.venaktesh.loan.service;

import com.venaktesh.loan.model.Loan;
import com.venaktesh.loan.model.ScheduleSheet;

public interface Schedules {

	public abstract ScheduleSheet createLoan(Loan laon);
	
}
