package com.venaktesh.loan;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping({ "/loan" })
public class LoanController {

	@Autowired
	LoanRepository loanRepository;
	@Autowired
	ScheduleRepository scheduleRepository;
	@Autowired
	Schedules scheduleGenerator;
	@Autowired
	PayInter payment;
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleSheet> create(@RequestBody Loan loan) {
		try {
			logger.info("Loan Post");
			ScheduleSheet _scheduleSheet = scheduleGenerator.createLoan(loan);
			loan.setCustID(_scheduleSheet.getCustID());
			loan.setLoanID(_scheduleSheet.getLoanID());
			loanRepository.save(loan);
			_scheduleSheet = scheduleRepository.save(_scheduleSheet);
			return new ResponseEntity<>(_scheduleSheet, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ScheduleSheet>> getSheet() {

		try {
			logger.info("SS get");
			List<ScheduleSheet> _scheduleSheet = scheduleRepository.findAll();
			return new ResponseEntity<>(_scheduleSheet, HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<Loan>> getLoans() {

		try {
			logger.info("Loan get");
			List<Loan> _loanApplication = loanRepository.findAll();

			return new ResponseEntity<>(_loanApplication, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/pay", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public String pay(@RequestBody String code) {

		try {
			logger.info("Payment post");
			payment.payLoan(code);
			return "success";
		} catch (Exception e) {
			logger.error("this is a error message");
			return "error";
		}

	}

}
