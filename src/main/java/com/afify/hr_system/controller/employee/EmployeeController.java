package com.afify.hr_system.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
	public Page<Employee> getAll(@RequestBody PageInfo page){
		return empService.getAllEmps(page);
	}
	@PostMapping("")
	public ResponseEntity<?>  addEmp(@RequestBody Employee emp){
		return empService.addEmp(emp);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable int id){
		return empService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?>  udpateEmp(@RequestBody Employee emp){
		return empService.updateEmp(emp);
	}
}
