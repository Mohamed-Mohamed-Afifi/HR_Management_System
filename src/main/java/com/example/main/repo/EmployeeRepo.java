package com.example.main.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.Departments;
import com.example.main.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findByDepartmentDepartmentNumber(int dnum);
}
