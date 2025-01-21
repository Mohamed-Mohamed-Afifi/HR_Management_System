package com.afify.hr_system.repo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.repo.employee.dao.PageFilter;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{
//    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department LEFT JOIN FETCH e.manager LEFT JOIN FETCH e.dependents")

    @EntityGraph(attributePaths = {"department", "manager","dependents"})
    public List<Employee> findByDepartmentDepartmentNumber(int num);
//    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department LEFT JOIN FETCH e.manager LEFT JOIN FETCH e.dependents")

    @EntityGraph(attributePaths = {"department", "manager","dependents"})
    public List<Employee> findByManagerSsn(int ssn);
	
//    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department LEFT JOIN FETCH e.manager LEFT JOIN FETCH e.dependents")

    @EntityGraph(attributePaths = {"department", "manager","dependents"})
	    public Optional<Employee> findById(int id);

//	    @EntityGraph(attributePaths = {"department", "manager","department.supervisor","department.supervisor.manager","department.supervisor.supervisor"})
//    @Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department LEFT JOIN FETCH e.manager LEFT JOIN FETCH e.dependents")

    @EntityGraph(attributePaths = {"department", "manager","dependents"})
	    public Page<Employee> findAll(Pageable page);
//	@Query("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.department LEFT JOIN FETCH e.manager LEFT JOIN FETCH e.dependents")
    @EntityGraph(attributePaths = {"department", "manager","dependents"})
	    Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);

	    
	
	
}
