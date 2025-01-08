package com.example.main.services.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.main.entity.project.Project;
import com.example.main.repo.project.ProjectRepo;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepo projectRepo;
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectRepo.findAll();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	public List<Project> addproject(Project project) {
        projectRepo.save(project);
        return projectRepo.findAll();
	}

	public List<Project> findProjectDeptId(int id) {
		return projectRepo.findByDepartmentDepartmentNumber(id);
	}
}
