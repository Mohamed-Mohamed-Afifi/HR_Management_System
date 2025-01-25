package com.afify.hr_system.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.controller.employee.PageInfo;
import com.afify.hr_system.error.RecordNotFoundException;
import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.mapper.employee.EmpPageMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.EmpPageDto;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.dependent.DependentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.employee.dao.PageFilter;
import com.afify.hr_system.repo.employee.dao.SearchArgs;
import com.afify.hr_system.repo.employee.dao.SearchDao;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EmployeeService{
	
	private final EmpMapper empMapper;
	
	private final EmployeeRepo empRepo;

	private final DependentRepo dependentRepo;

	private final PrjEmpRepo prjEmpRepo;
	
	private final EmpPageMapper empPageMapper;
	
	private final DepartmentRepo departmentRepo;
	

	public EmpPageDto getAllEmps(PageInfo pageInfo){
		Pageable pageable=PageRequest.of(pageInfo.getPageNum()-1,pageInfo.getPageSize());
		Page<Employee> pagedEmp=empRepo.findAll(pageable);
		EmpPageDto empPageDto=empPageMapper.map(pagedEmp);
		return empPageDto;
	}
	public ResponseEntity<?> getEmployee(int id){
		
		Optional<Employee> entity=empRepo.findById(id);
		Employee emp;
		if(!entity.isPresent()) {
			throw new RecordNotFoundException("Record Not found");
		}else {
			emp=empRepo.findById(id).get();
		}
//		if(emp.Prisist)
		EmpDTO empDto=empMapper.empToDto(emp);
		return ResponseEntity.ok(empDto);
	}
	public ResponseEntity<?> addEmp(EmpDTO empDto){

		Employee employee=empMapper.maptoEntity(empDto);
		empRepo.save(employee);
		return ResponseEntity.ok(null);
	} 
	
	public ResponseEntity<?> updateEmp(EmpDTO empDto){
		Employee employee=empMapper.maptoEntity(empDto);
		empRepo.save(employee);
		return ResponseEntity.ok(null);
	} 
	public ResponseEntity<?> search(PageFilter pageFilter){
			SearchDao searchDao=new SearchDao(pageFilter.getSearchArgs());
			Pageable pageable =PageRequest.of(pageFilter.getPageNumber()-1, pageFilter.getPageSize());
			Page<Employee> employess=empRepo.findAll(searchDao,pageable);
			EmpPageDto empPageDto=empPageMapper.map(employess);
		return ResponseEntity.ok(empPageDto);
	}
	@Transactional
	public ResponseEntity<?> deleteById(int id){
		List<Employee> employees=empRepo.findByManagerSsn(id);
		employees.forEach(emp->{
			emp.setManager(null);
		});
		empRepo.saveAll(employees);
		List<Department> departments=departmentRepo.findBySupervisorSsn(id);
		departments.forEach(dept->{
			dept.setSupervisor(null);
		});
		departmentRepo.saveAll(departments);
		dependentRepo.deleteByEmpSsn(id);
		prjEmpRepo.deleteByEmpSsn(id);
		
		empRepo.deleteById(id);
		return ResponseEntity.ok(null);
	} 
}
