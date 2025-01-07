package com.example.main.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.main.entity.Project;

public interface ProjectRepo extends ListCrudRepository<Project, Integer> {

	public List<Project> findByDepartmentDepartmentNumber(int dnum);
}
