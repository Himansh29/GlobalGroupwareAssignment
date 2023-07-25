package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        // The 'id' field will be generated automatically by MongoDB
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
            existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setReportsTo(updatedEmployee.getReportsTo());
            existingEmployee.setProfileImage(updatedEmployee.getProfileImage());

            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }

    public Employee getNthLevelManager(Long employeeId, int level) {
        if (level < 1) {
            throw new IllegalArgumentException("The level must be greater than or equal to 1.");
        }

        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return null; // Employee not found with the given ID
        }

        return findNthLevelManager(employee, level);
    }

    // Recursive method to find the nth level manager
    private Employee findNthLevelManager(Employee employee, int level) {
        if (employee.getReportsTo() == null || level == 0) {
            return employee;
        }

        UUID managerReportsTo = employee.getReportsTo();
        Employee manager = employeeRepository.findByReportsTo(managerReportsTo);

        if (manager == null) {
            return null; // Manager not found with the given reportsTo (UUID)
        }

        return findNthLevelManager(manager, level - 1);
    }
	
	
}
    
