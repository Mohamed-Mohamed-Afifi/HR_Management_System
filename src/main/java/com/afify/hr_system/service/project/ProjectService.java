package com.afify.hr_system.service.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.project.PrjPageDtoMapper;
import com.afify.hr_system.mapper.project.ProjectMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectDto;
import com.afify.hr_system.model.projects.ProjectPageDto;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.repo.project.search.PageSearchSpec;
import com.afify.hr_system.repo.project.search.SearchArgs;
import com.afify.hr_system.repo.project.search.SearchSpec;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectMapper projectMapper;
	
	private final ProjectRepo projectRepo;

	private final PrjEmpRepo prjEmpRepo;
	
	private final PrjPageDtoMapper prjPageDtoMapper;
	
	public ProjectPageDto getAllProjects(int pageNum,int pageSize){
		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Project> projects=projectRepo.findAll(pageable);
		ProjectPageDto prjPageDto=prjPageDtoMapper.map(projects);
		return prjPageDto;
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
	public ResponseEntity<?> filter(PageSearchSpec pageSearchSpec){
		Pageable pageable=PageRequest.of(pageSearchSpec.getPageNum(), pageSearchSpec.getPageSize());
		SearchSpec searchSpec=new SearchSpec(pageSearchSpec.getSearchArgs());
		Page<Project> projectPage=projectRepo.findAll(searchSpec, pageable);
		System.out.println(projectPage);
		ProjectPageDto prjPageDto=prjPageDtoMapper.map(projectPage);
		return ResponseEntity.ok(prjPageDto);
	}
}
