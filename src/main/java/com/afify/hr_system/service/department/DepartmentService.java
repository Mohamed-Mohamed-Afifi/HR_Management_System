package com.afify.hr_system.service.department;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.department.DeptMapper;
import com.afify.hr_system.mapper.department.DeptPageDtoMapper;
import com.afify.hr_system.model.department.DepartDto;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.department.PageDeptDto;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.department.search.DeptPageFilter;
import com.afify.hr_system.repo.department.search.SearchDao;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project.ProjectRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	private final DepartmentRepo deptRepo;
	private final EmployeeRepo empRepo;
	private final ProjectRepo prjRepo;
	private final DeptPageDtoMapper deptPageMapper;
	private final DeptMapper departMapper;
	
	public PageDeptDto getAlldepts(int pageNumber,int pageSize){
		Pageable pageable=PageRequest.of(pageNumber,pageSize);
		Page<Department> deptPage=deptRepo.findAll(pageable);
		PageDeptDto deptPageDto=deptPageMapper.map(deptPage);
		return deptPageDto;
	}
	
	public ResponseEntity<?> addDept(DepartDto dept){
		Department deptDto=departMapper.umMap(dept);
		deptRepo.save(deptDto);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> update(DepartDto dept){
		Department deptDto=departMapper.umMap(dept);
		deptRepo.save(deptDto);
		return ResponseEntity.ok(null);
	} 
	public ResponseEntity<?> filter(DeptPageFilter deptfilter){
			Pageable pegable=PageRequest.of(deptfilter.getPageNumber()-1, deptfilter.getPageSize());
			SearchDao searchSpec=new SearchDao(deptfilter.getSearchArgs());
			Page<Department> departmentPage=deptRepo.findAll(searchSpec,pegable);
			PageDeptDto pageDto=deptPageMapper.map(departmentPage);
		return ResponseEntity.ok(pageDto);
	}
	
	@Transactional
	public ResponseEntity<?> deleteById(int id){
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
		return ResponseEntity.ok("ok");
	} 
}
