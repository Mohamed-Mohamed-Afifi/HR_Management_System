package com.afify.hr_system.controller.department;

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

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.service.department.DepartmentService;
@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("")
	public List<Department> getAll(){
		return deptService.getAlldepts();
	}
	@PostMapping("")
	public List<Department> addEmp(@RequestBody Department dept){
		return deptService.addDept(dept);
	}
	@DeleteMapping("/{id}")
	public List<Department> deleteEmp(@PathVariable int id){
		return deptService.deleteById(id);
	}
	@PutMapping("")
	public List<Department> udpateEmp(@RequestBody Department dept){
		return deptService.update(dept);
	}
}
