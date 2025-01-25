package com.afify.hr_system.controller.projects;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.model.projects.ProjectDto;
import com.afify.hr_system.service.project.ProjectService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {

	private final ProjectService prjService;
	
	@GetMapping("")
	public List<ProjectDto> getAll(){
		return prjService.getAllProjects();
	}
	@PostMapping("")
	public ResponseEntity<?> addEmp(@RequestBody @Valid ProjectDto prj){
		return prjService.addProject(prj);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteEmp(@PathVariable @NotNull int id){
		return prjService.deleteById(id);
	}
	@PutMapping("")
	public ResponseEntity<?>  udpateEmp(@RequestBody @Valid ProjectDto prj){
		return prjService.update(prj);
	}
}
