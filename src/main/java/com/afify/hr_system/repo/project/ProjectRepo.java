package com.afify.hr_system.repo.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afify.hr_system.model.projects.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
	public List<Project> findByDepartmentDepartmentNumber(int id);
	@Query("delete from Project prj where prj.department.departmentNumber =:id")
	public void DeleteByDepartmentDepartmentNumber(int id);
}
