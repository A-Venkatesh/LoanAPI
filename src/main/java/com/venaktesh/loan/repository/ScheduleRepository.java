package com.venaktesh.loan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.venaktesh.loan.model.ScheduleSheet;

@Repository
public interface ScheduleRepository extends MongoRepository<ScheduleSheet, String> {

}