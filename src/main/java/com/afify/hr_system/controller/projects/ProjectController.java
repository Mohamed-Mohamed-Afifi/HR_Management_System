package com.afify.hr_system.controller.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectDto;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.service.project.ProjectService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

	private final ProjectService prjService;
	
	@GetMapping("")
	public List<ProjectDto> getAll(){
		return prjService.getAllProjects();
	}
	@PostMapping("")
	public ResponseEntity<?> addEmp(@RequestBody ProjectDto prj){
		return prjService.addProject(prj);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteEmp(@PathVariable int id){
		return prjService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?>  udpateEmp(@RequestBody Project prj){
		return prjService.update(prj);
	}
}
