package com.venaktesh.loan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

@Service
public class ScheduleGenerator implements Schedules {

	@Override
	public ScheduleSheet createLoan(Loan loan) {

		System.out.println(loan.isExist());
		ScheduleSheet ss = new ScheduleSheet();
		if (loan.isExist()) {
			ss.setCustID(loan.getCustID());
		} else {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			System.out.println(number);
			ss.setCustID(number);
		}
		List<Schedule> evenPrincipal = new ArrayList<Schedule>();
		List<Schedule> interestOnly = new ArrayList<Schedule>();

		int freq = getFreq(loan.getFrequency(), loan.getTerm(), loan.getMatric());
		System.out.println(freq);
		System.out.println(getType(loan.getMatric()));
		double r = (loan.getIntrestRate() / 100) / getType(loan.getFrequency());
		System.out.println(r);
		double payment = Payment(loan.getLoanAmount(), r, freq);
		System.out.println(payment);
		double loanamt = loan.getLoanAmount();
		Date date = loan.getLoanStartDate();
		for (int i = freq; i > 0; i--) {
			Schedule sc = new Schedule();
			date = DateUtils.addMonths(date, 1);
			sc.setPaymentDate(date);
			sc.setStartingBalance(loanamt);
			sc.setPaymentAmount(payment);
			sc.setPaymentStatus("PROJECTED");
			r = (loan.getIntrestRate() / 100) / getType(loan.getFrequency());
			double intrest = r * loanamt;
			sc.setProjectedInterest(intrest);
			loanamt = loanamt - (payment - intrest);
			sc.setPrincipal(payment - intrest);
			sc.setNewBalance(loanamt);
			evenPrincipal.add(sc);
		}

		loanamt = loan.getLoanAmount();
		date = loan.getLoanStartDate();
		for (int i = freq; i > 0; i--) {
			Schedule sc = new Schedule();
			date = DateUtils.addMonths(date, 1);
			sc.setPaymentDate(date);
			sc.setStartingBalance(loanamt);

			sc.setPaymentStatus("PROJECTED");
			r = (loan.getIntrestRate() / 100) / getType(loan.getFrequency());
			double intrest = r * loanamt;

			sc.setPaymentAmount(intrest);
			sc.setProjectedInterest(intrest);
			sc.setPrincipal(0.00);
			sc.setNewBalance(loanamt);
			if (i == 1) {
				sc.setPaymentAmount(intrest + loanamt);
				sc.setNewBalance(0.00);
				sc.setPrincipal(loanamt);
			}
			interestOnly.add(sc);
		}
		ss.setInterestOnly(interestOnly);
		ss.setEvenPrincipal(evenPrincipal);

		System.out.println(String.valueOf(new Date().getTime()));
		ss.setLoanID(String.valueOf(new Date().getTime()));
		return ss;
	}

	static double Payment(int p, double r, int t) {
		// double m = (p * r) / (1 - Math.pow(1 + r, -t));
		// m = Math.round(m * 100) / 100;
		double emi;

		// r = r / (12 * 100); // one month interest
		// t = t * 12; // one month period
		emi = (p * r * (double) Math.pow(1 + r, t)) / (double) (Math.pow(1 + r, t) - 1);

		return (emi);
		// return m;
	}

	static int getFreq(String freq, int term, String mat) {
		int no = 1;
		int fe = term;
		if (mat.equals("year")) {
			no = term * 12;
		} else {
			no = term;
		}
		switch (freq) {
		case "Quarterly":
			fe = no / 3;
			break;
		case "Half Yearly":
			fe = no / 6;
			break;
		case "Yearly":
			fe = no / 12;
			break;
		default:
			fe = no;
			break;
		}
		return fe;
	}

	static int getType(String freq) {
		System.out.println(freq);
		int fe = 12;
		if (freq.equals("Quarterly")) {
			fe = 4;
		} else if (freq.equals("Half Yearly")) {
			fe = 2;
		} else if (freq.equals("Yearly")) {
			fe = 1;
		}

		return fe;
	}
}
