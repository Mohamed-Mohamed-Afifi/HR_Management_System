package com.afify.hr_system.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.controller.employee.PageInfo;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.repo.dependent.DependentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DependentRepo dependentRepo;
	@Autowired
	private PrjEmpRepo prjEmpRepo;
	
	public Page<Employee> getAllEmps(PageInfo pageInfo){
		Pageable pageable=PageRequest.of(pageInfo.getPageNum()-1,pageInfo.getPageSize());
		return empRepo.findAll(pageable);
	}
	
	public ResponseEntity<?> addEmp(Employee emp){
		empRepo.save(emp);
		
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> updateEmp(Employee emp){
		empRepo.save(emp);
		return ResponseEntity.ok(null);
	} 
	@Transactional
	public ResponseEntity<?> deleteById(int id){
		List<Employee> employees=empRepo.findByManagerSsn(id);
		employees.forEach(emp->{
			emp.setManager(null);
		});
		empRepo.saveAll(employees);
		dependentRepo.deleteByEmpSsn(id);
		prjEmpRepo.deleteByEmpSsn(id);
		
		empRepo.deleteById(id);
		return ResponseEntity.ok(null);
	} 
}
