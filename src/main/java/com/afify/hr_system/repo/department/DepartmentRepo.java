package com.afify.hr_system.repo.department;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.projects.Project;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	@EntityGraph(attributePaths = {"supervisor","employees","projects"})
	public List<Department> findAll();
	@EntityGraph(attributePaths = {"supervisor","employees","projects"})
	public List<Department> findById(int id);
}
