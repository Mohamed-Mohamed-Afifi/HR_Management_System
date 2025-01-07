package com.example.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.Departments;
//import com.example.main.repo.DepartmentRepo;
import com.example.main.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
//	@Autowired
//	private DepartmentRepo deptRepo;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/count")
	public int getDeptCount() {
		return deptService.getDeptCount() ;
	}
	@GetMapping("")
	public List<Departments> getAllDepartments() {
		return deptService.getAllDepartments();
	}
	@GetMapping("/{ids}")
	public Departments getDepartmentById(@PathVariable("ids")  Integer id) {
		return deptService.getDepartmentById(id);
	}
	@GetMapping("/dept") //http://localhost:8080/departments/dept?name=MM
	public List<Departments> getDepartmentByName(@RequestParam("name") String dname) {
		return deptService.getDepartmentByName(dname);
	}
	@PutMapping("")
	public List<Departments> updateDepartment(@RequestBody Departments dept) {
		return deptService.updateDepartment(dept);
	}
	@PostMapping("")
	public ResponseEntity<List<Departments>> addDepartment(@RequestBody Departments dept,@RequestHeader("Authorization") String auth) {
		
		System.out.println("Auth: "+auth);
		
		return deptService.addDepartment(dept,auth);
	}
	@DeleteMapping("/{DeptId}")
	public List<Departments> deleteDepartment(@PathVariable("DeptId") Integer id) {
		return deptService.deleteDepartment(id);
	}
	@GetMapping("/employees/{ssn}")
	public List<Departments> getManagedDepartments(@PathVariable int ssn){
		return deptService.findDepartmentsManagedBySsn(ssn);
	}
}
