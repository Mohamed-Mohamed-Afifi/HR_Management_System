package com.afify.hr_system.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
@Service
public class ProjectService {
	@Autowired
	private ProjectRepo projectRepo;
	@Autowired
	private PrjEmpRepo prjEmpRepo;
	
	public List<Project> getAllProjects(){
		return projectRepo.findAll();
	}
	
	public ResponseEntity<?> addProject(Project pro){
		projectRepo.save(pro);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> update(Project pro){
		projectRepo.save(pro);
		return ResponseEntity.ok(null);
	} 
	@Transactional
	public ResponseEntity<?> deleteById(int id){
		prjEmpRepo.deleteByProjectNum(id);
		projectRepo.deleteById(id);
		return ResponseEntity.ok(null);
	} 
}
