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
import com.afify.hr_system.service.project.ProjectService;
@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService prjService;
	
	@GetMapping("")
	public List<Project> getAll(){
		return prjService.getAllProjects();
	}
	@PostMapping("")
	public ResponseEntity<?> addEmp(@RequestBody Project prj){
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
