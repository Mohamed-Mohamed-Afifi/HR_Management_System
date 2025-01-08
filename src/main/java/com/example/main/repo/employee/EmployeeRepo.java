package com.example.main.repo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.department.Departments;
import com.example.main.entity.employee.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findByDepartmentDepartmentNumber(int dnum);
}
