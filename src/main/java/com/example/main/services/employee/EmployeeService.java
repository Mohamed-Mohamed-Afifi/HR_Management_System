package com.example.main.services.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.employee.Employee;
import com.example.main.repo.employee.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee addEmployee(Employee emp){
		employeeRepo.save(emp);
		return employeeRepo.findById(emp.getSsn()).get();
	}
	
}
