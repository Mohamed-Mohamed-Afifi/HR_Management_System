package com.afify.hr_system.controller.department;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.controller.employee.PageInfo;
import com.afify.hr_system.model.department.DepartDto;
import com.afify.hr_system.model.department.PageDeptDto;
import com.afify.hr_system.repo.department.search.DeptPageFilter;
import com.afify.hr_system.service.department.DepartmentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Validated
public class DepartmentController {
	private final DepartmentService deptService;
	
	@GetMapping("")
	public PageDeptDto getAll(@RequestParam("pageNumber") int pageNumber,@RequestParam("pageSize") int pageSize){
		return deptService.getAlldepts(pageNumber,pageSize);
	}
	@PostMapping("")
	public ResponseEntity<?>  addEmp(@RequestBody @Valid DepartDto dept){
		return deptService.addDept(dept);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteEmp(@PathVariable @NotNull int id){
		return deptService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?> udpateEmp(@RequestBody @Valid DepartDto dept){
		return deptService.update(dept);
	}
	@PostMapping("/search")
	public ResponseEntity<?>  addEmp(@RequestBody DeptPageFilter dept){
		return deptService.filter(dept);
	}
}
