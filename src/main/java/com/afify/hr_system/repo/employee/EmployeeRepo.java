package com.afify.hr_system.repo.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afify.hr_system.model.employee.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findByDepartmentDepartmentNumber(int num);
	public List<Employee> findByManagerSsn(int ssn);
	
}
