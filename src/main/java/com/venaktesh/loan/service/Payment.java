package com.venaktesh.loan.service;
import org.springframework.stereotype.Service;

import com.venaktesh.loan.repository.ScheduleRepository;

@Service
public class Payment implements PayInter{

	ScheduleRepository scheduleRepository;
	
	@Override
	public Payment payLoan(String code) {

		
		String index = code.substring(code.indexOf("|")+1);
		String type = code.substring(0, code.indexOf("|"));
		System.out.println(type);
		System.out.println(index);
		return null;
	}


}
