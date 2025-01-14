package com.afify.hr_system.repo.department;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.department.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
}
