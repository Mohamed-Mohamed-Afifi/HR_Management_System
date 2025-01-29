package com.afify.hr_system.repo.project;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.afify.hr_system.model.projects.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> , JpaSpecificationExecutor<Project>{
	@EntityGraph(attributePaths = {"department","employees"})
	public List<Project> findByDepartmentDepartmentNumber(int id);
	@Query("delete from Project prj where prj.department.departmentNumber =:id")
	public void DeleteByDepartmentDepartmentNumber(int id);
	@EntityGraph(attributePaths = {"department","employees"})
	public List<Project> findAll();
	@EntityGraph(attributePaths = {"department","employees"})
	public List<Project> findById(int id);
//	@EntityGraph(attributePaths = {"department","employees"})
//	public Page<Project> findAll(Specification<Project> spec,Pageable page);
}
