package com.venaktesh.loan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.venaktesh.loan.model.Loan;

@Repository
	public interface LoanRepository extends MongoRepository<Loan, String> {
		  
	}