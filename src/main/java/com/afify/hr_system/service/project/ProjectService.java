package com.afify.hr_system.service.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.project.ProjectMapper;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectDto;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectMapper projectMapper;
	
	private final ProjectRepo projectRepo;

	private final PrjEmpRepo prjEmpRepo;
	
	public List<ProjectDto> getAllProjects(){
		List<Project> projects=projectRepo.findAll();
		List<ProjectDto> projectsDto=projects.stream().map(projectMapper::map).collect(Collectors.toList());
		return projectsDto;
	}
	
	public ResponseEntity<?> addProject(ProjectDto proDto){
		Project pro=projectMapper.unmaped(proDto);
		projectRepo.save(pro);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> update(ProjectDto proDto){
		Project pro=projectMapper.unmaped(proDto);
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
