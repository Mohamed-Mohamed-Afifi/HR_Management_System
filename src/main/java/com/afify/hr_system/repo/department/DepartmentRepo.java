package com.afify.hr_system.repo.department;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;

public interface DepartmentRepo extends JpaRepository<Department, Integer>,JpaSpecificationExecutor<Department>{
	@EntityGraph(attributePaths = {"supervisor","supervisor.manager","employees","projects"})
	public List<Department> findAll();
	@EntityGraph(attributePaths = {"supervisor","supervisor.manager","employees","projects"})
	public List<Department> findById(int id);
	
//	@EntityGraph(attributePaths = {"supervisor","supervisor.manager","employees","projects"})
//	public List<Department> findBySupervisorSsn(int ssn);
	
	@Query("SELECT d FROM Department d LEFT JOIN FETCH d.supervisor s WHERE s.ssn = :ssn")
	List<Department> findBySupervisorSsn(@Param("ssn") int ssn);
	
//	@EntityGraph(attributePaths = {"supervisor","supervisor.manager","employees","projects"})
//    Page<Department> findAll(Specification<Department> spec, Pageable pageable);

}
