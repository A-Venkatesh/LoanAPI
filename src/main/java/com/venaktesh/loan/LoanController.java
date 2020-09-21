package com.venaktesh.loan;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
	ScheduleGenerator scheduleGenerator;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScheduleSheet> create(@RequestBody Loan loan) {
		System.out.println(loan.toString());
		try {
			
			ScheduleSheet _scheduleSheet = scheduleGenerator.createLoan(loan);
			loan.setCustID(_scheduleSheet.getCustID());
			loan.setLoanID(_scheduleSheet.getLoanID());
			Loan _loanApplication = loanRepository.save(loan);
			_scheduleSheet = scheduleRepository.save(_scheduleSheet);
			return new ResponseEntity<>(_scheduleSheet, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("pppppppppppppppppppppppppppppppppppppp" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return loan;
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ScheduleSheet>> create(@RequestBody String ID) {
//		System.out.println(loan.toString());
		try {
			
			List<ScheduleSheet> _scheduleSheet = scheduleRepository.findAll();
	return new ResponseEntity<>(_scheduleSheet, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("pppppppppppppppppppppppppppppppppppppp");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return loan;
	}
}
