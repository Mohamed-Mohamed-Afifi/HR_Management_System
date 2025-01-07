package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.Project;
import com.example.main.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@GetMapping("")
	public ResponseEntity<List<Project>> getProjects() {
		return projectService.getAllProjects();
	}
	@PostMapping("")
	public List<Project> addProject(@RequestBody Project project) {
		return projectService.addproject(project);
	}
	@GetMapping("/dept/{id}")
	public List<Project> getProjectsByDeptId(@PathVariable int id) {
		return projectService.findProjectDeptId(id);
	}
}
