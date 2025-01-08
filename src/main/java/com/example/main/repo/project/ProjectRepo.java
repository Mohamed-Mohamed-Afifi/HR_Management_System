package com.example.main.repo.project;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.main.entity.project.Project;

public interface ProjectRepo extends ListCrudRepository<Project, Integer> {

	public List<Project> findByDepartmentDepartmentNumber(int dnum);
}
