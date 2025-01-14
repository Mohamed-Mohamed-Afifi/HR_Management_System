package com.afify.hr_system.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Employee> getAllEmps(){
		return empRepo.findAll();
	}
	
	public List<Employee> addEmp(Employee emp){
		empRepo.save(emp);
		return empRepo.findAll();
	} 
	
	public List<Employee> updateEmp(Employee emp){
		empRepo.save(emp);
		return empRepo.findAll();
	} 
	@Transactional
	public List<Employee> deleteById(int id){
		List<Employee> employees=empRepo.findByManagerSsn(id);
		employees.forEach(emp->{
			emp.setManager(null);
		});
		empRepo.saveAll(employees);
		dependentRepo.deleteByEmpSsn(id);
		prjEmpRepo.deleteByEmpSsn(id);
		
		empRepo.deleteById(id);
		return empRepo.findAll();
	} 
}
