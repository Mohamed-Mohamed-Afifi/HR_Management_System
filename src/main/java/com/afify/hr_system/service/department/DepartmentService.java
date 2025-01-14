package com.afify.hr_system.service.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project.ProjectRepo;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private ProjectRepo prjRepo;
	
	public List<Department> getAlldepts(){
		return deptRepo.findAll();
	}
	
	public List<Department> addDept(Department dept){
		deptRepo.save(dept);
		return deptRepo.findAll();
	} 
	
	public List<Department> update(Department dept){
		deptRepo.save(dept);
		return deptRepo.findAll();
	} 
	
	@Transactional
	public List<Department> deleteById(int id){
		List<Employee> employees=empRepo.findByDepartmentDepartmentNumber(id);
		employees.forEach(emp->{
			emp.setDepartment(null);
		});
		empRepo.saveAll(employees);
		
		List<Project> projects=prjRepo.findByDepartmentDepartmentNumber(id);
		projects.forEach(prj->{
			prj.setDepartment(null);
		});
		prjRepo.saveAll(projects);
		deptRepo.deleteById(id);
		return deptRepo.findAll();
	} 
}
