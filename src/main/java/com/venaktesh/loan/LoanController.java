package com.venaktesh.loan;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({ "/loan" })
public class LoanController {

	@Autowired
	LoanRepository loanRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> create(@RequestBody Loan loan) {
		System.out.println(loan.toString());
		try {
		    Loan _loanApplication = loanRepository.save(loan);
		    return new ResponseEntity<>(_loanApplication, HttpStatus.CREATED);
		  } catch (Exception e) {
			  System.out.println("pppppppppppppppppppppppppppppppppppppp");
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
//		return loan;
	}
	
	@PostMapping(value = "/application")
	public ResponseEntity<Loan> create1(@RequestBody Loan loan) {
		System.out.println(loan.toString());
		try {
		    Loan _loanApplication = loanRepository.save(loan);
		    return new ResponseEntity<>(_loanApplication, HttpStatus.CREATED);
		  } catch (Exception e) {
			  System.out.println("pppppppppppppppppppppppppppppppppppppp");
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
//		return loan;
	}
	
}
