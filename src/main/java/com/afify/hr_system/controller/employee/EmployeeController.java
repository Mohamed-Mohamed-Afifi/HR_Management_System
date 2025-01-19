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

import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.EmpPageDto;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.service.employee.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService empService;
	
	@GetMapping("")
	public EmpPageDto getAll(@RequestBody PageInfo page){
		return empService.getAllEmps(page);
	}
	@GetMapping("/{ssn}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int ssn) {
		return empService.getEmployee(ssn);
	}
	@PostMapping("")
	public ResponseEntity<?>  addEmp(@RequestBody EmpDTO empDto){
		return empService.addEmp(empDto);
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
