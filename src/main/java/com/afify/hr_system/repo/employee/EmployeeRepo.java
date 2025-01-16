package com.afify.hr_system.repo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afify.hr_system.model.employee.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @EntityGraph(attributePaths = {"department", "manager"})
    public List<Employee> findByDepartmentDepartmentNumber(int num);
    @EntityGraph(attributePaths = {"department", "manager"})
    public List<Employee> findByManagerSsn(int ssn);
	
	    @EntityGraph(attributePaths = {"department", "manager"})
	    public Optional<Employee> findById(int id);

//	    @EntityGraph(attributePaths = {"department", "manager","department.supervisor","department.supervisor.manager","department.supervisor.supervisor"})
	    @EntityGraph(attributePaths = {"department", "manager"})
	    public Page<Employee> findAll(Pageable page);
	
	
}
