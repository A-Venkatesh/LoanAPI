package com.venaktesh.loan;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
	public interface LoanRepository extends MongoRepository<Loan, String> {

//		  List<LoanApplication> findByID(Object id);
//		  List<LoanApplication> findByCustID(int custID);
		  
	}