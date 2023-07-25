package com.example.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {
	Employee findByReportsTo(UUID reportsTo);
}
