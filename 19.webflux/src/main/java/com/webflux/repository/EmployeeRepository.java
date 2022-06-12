package com.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.webflux.entity.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}
