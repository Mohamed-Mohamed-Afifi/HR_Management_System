package com.example.main.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.entity.Departments;
import com.example.main.entity.Employee;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Integer>{
	
	public List<Departments> findByDepartmentName(String dname);
//	@Modifying
//	@Query("INSERT INTO Department (dname, capacity, employees, createdAt) VALUES (:dname, :capacity, :employees, :createdAt)")
//	@Transactional
//	void addDepartment(@Param("dname") String dname,
//	                   @Param("capacity") Integer capacity,
//	                   @Param("employees") Integer employees,
//	                   @Param("createdAt") LocalDateTime createdAt);
	
	public  List<Departments> findByManagerOfDeptSsn(int ssn);

}
