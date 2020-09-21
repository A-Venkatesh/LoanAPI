package com.venaktesh.loan;
import org.springframework.stereotype.Service;

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
