package com.venaktesh.loan;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository  extends MongoRepository<ScheduleSheet, String> {


//	public ScheduleSheet getDetail(String id);
}