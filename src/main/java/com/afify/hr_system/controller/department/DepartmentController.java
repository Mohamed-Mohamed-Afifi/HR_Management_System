package com.afify.hr_system.controller.department;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.controller.employee.PageInfo;
import com.afify.hr_system.model.department.DepartDto;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.department.PageDeptDto;
import com.afify.hr_system.service.department.DepartmentService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
	private final DepartmentService deptService;
	
	@GetMapping("")
	public PageDeptDto getAll(@RequestBody PageInfo page){
		return deptService.getAlldepts(page);
	}
	@PostMapping("")
	public ResponseEntity<?>  addEmp(@RequestBody DepartDto dept){
		return deptService.addDept(dept);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteEmp(@PathVariable int id){
		return deptService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?> udpateEmp(@RequestBody Department dept){
		return deptService.update(dept);
	}
}
