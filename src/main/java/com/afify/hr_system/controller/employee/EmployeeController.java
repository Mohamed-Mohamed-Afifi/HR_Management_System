package com.afify.hr_system.controller.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.afify.hr_system.repo.employee.dao.PageFilter;
import com.afify.hr_system.service.employee.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:5173")
@PreAuthorize("hasRole('ADMIN')")
public class EmployeeController {

	private final EmployeeService empService;
	
	@GetMapping("")
	@PreAuthorize("hasAuthority('admin:read')")
	public EmpPageDto getAll(@RequestBody PageInfo page){
		return empService.getAllEmps(page);
	}
	@GetMapping("/{ssn}")
	public ResponseEntity<?> getEmployeeById(@PathVariable @NotNull int ssn) {
		return empService.getEmployee(ssn);
	}
	@PostMapping("")
	public ResponseEntity<?>  addEmp(@RequestBody @Valid EmpDTO empDto){
		return empService.addEmp(empDto);
	}
	@PostMapping("/search")
	public ResponseEntity<?>  search(@RequestBody PageFilter searchArgs){
		return empService.search(searchArgs);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable @NotNull int id){
		return empService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?>  udpateEmp(@RequestBody @Valid EmpDTO emp){
		return empService.updateEmp(emp);
	}
}
