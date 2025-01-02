package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.modal.Employee;
import com.example.main.repo.EmployeeRepo;
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	@GetMapping("/empcount")
	public Integer getEmployeeCount() {
		return employeeRepo.getEmployeeCount();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Employee emp= employeeRepo.getEmployeeById(id);
		return emp;
	}
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeRepo.getEmployees();
	}
	
	@GetMapping("/employees/add")
	public List<Employee> addEmployee(Employee employee) {
		employeeRepo.addEmployee(new Employee(77777, "afify", "araby", "1990-01-01", "123 Main St", "M", 15000, 102672, 10));
		return employeeRepo.getEmployees();
	}
	@GetMapping("/employees/delete")
	public void deleteEmployee() {
		employeeRepo.deleteEmployee(77777);
	}
	@GetMapping("/employees/update")
	public List<Employee> updateEmployee() {
		employeeRepo.updateEmployee(
				new Employee(77777, "afifyyy", "arabyyy", "1990-01-01", "123 Main St", "M", 15000, 102672, 10));
		return employeeRepo.getEmployees();
	}
}
