package com.afify.hr_system.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.service.employee.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("")
	public List<Employee> getAll(){
		return empService.getAllEmps();
	}
	@PostMapping("")
	public List<Employee> addEmp(@RequestBody Employee emp){
		return empService.addEmp(emp);
	}
	@DeleteMapping("/{id}")
	public List<Employee> deleteEmp(@PathVariable int id){
		return empService.deleteById(id);
	}
	@PutMapping("")
	public List<Employee> udpateEmp(@RequestBody Employee emp){
		return empService.updateEmp(emp);
	}
}
