package com.afify.hr_system.service.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afify.hr_system.controller.employee.PageInfo;
import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.EmpPageDto;
import com.afify.hr_system.model.employee.Employee;
import com.afify.hr_system.repo.department.DepartmentRepo;
import com.afify.hr_system.repo.dependent.DependentRepo;
import com.afify.hr_system.repo.employee.EmployeeRepo;
import com.afify.hr_system.repo.project.ProjectRepo;
import com.afify.hr_system.repo.project_employee.PrjEmpRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmpMapper empMapper;
	
	private final EmployeeRepo empRepo;

	private final DependentRepo dependentRepo;

	private final PrjEmpRepo prjEmpRepo;
//	
//	public EmpDTO mapToDto(Employee emp) {
//		EmpDTO empDto=new EmpDTO();
//		empDto.setAddress(emp.getAddress());
//		empDto.setBirthdate(emp.getBdate());
//		empDto.setFirst_name(emp.getFname());
//		empDto.setLast_name(emp.getLname());
//		empDto.setSalary(emp.getSalary());
//		empDto.setSsn(emp.getSsn());
//		empDto.setSex(emp.getSex());
//		if(emp.getDepartment()!=null) {
//			empDto.setDepartment_number(emp.getDepartment().getDepartmentNumber());			
//		}
//		if(emp.getManager()!=null) {
//			empDto.setManager_ssn(emp.getManager().getSsn());			
//		}
//		return empDto;
//	}
	public EmpPageDto getAllEmps(PageInfo pageInfo){
		Pageable pageable=PageRequest.of(pageInfo.getPageNum()-1,pageInfo.getPageSize());
		Page<Employee> pagedEmp=empRepo.findAll(pageable);
		List<EmpDTO> employeeDto=pagedEmp.getContent().stream().map((emp)->empMapper.empToDto(emp)).collect(Collectors.toList());
		EmpPageDto empPageDto=new EmpPageDto();
		empPageDto.setEmployees(employeeDto);
		empPageDto.setPageNumber(pagedEmp.getNumber());
		empPageDto.setPageSize(pagedEmp.getSize());
		empPageDto.setTotalPages(pagedEmp.getTotalPages());
		return empPageDto;
	}
	public ResponseEntity<?> getEmployee(int id){
//		EmpDTO empDto=new EmpDTO();
//		Employee emp=empRepo.findById(id).get();
//		empDto.setSsn(emp.getSsn());
//		empDto.setAddress(emp.getAddress());
//		empDto.setBirthdate(emp.getBdate());
//		empDto.setSalary(emp.getSalary());
//		empDto.setSex(emp.getSex());
//		empDto.setFirst_name(emp.getFname());
//		empDto.setLast_name(emp.getLname());
//		if(emp.getManager()!=null) {
//			empDto.setManager_ssn(emp.getManager().getSsn());			
//		}else {
//			empDto.setManager_ssn(null);
//		}
//		if(emp.getDepartment()!=null) {
//			empDto.setDepartment_number(emp.getDepartment().getDepartmentNumber());
//		
//		}else {
//			empDto.setDepartment_number(null);
//		}
		Employee emp=empRepo.findById(id).get();
		EmpDTO empDto=empMapper.empToDto(emp);
		return ResponseEntity.ok(empDto);
	}
	public ResponseEntity<?> addEmp(EmpDTO empDto){
//		Employee employee=new Employee();
//		employee.setAddress(empDto.getAddress());
//		employee.setBdate(empDto.getBirthdate());
//		employee.setFname(empDto.getFirst_name());
//		employee.setLname(empDto.getLast_name());
//		employee.setSalary(empDto.getSalary());
//		employee.setSsn(empDto.getSsn());
//		employee.setSex(empDto.getSex());
//		Employee manager=new Employee();
//		manager.setSsn(empDto.getManager_ssn());
//		employee.setManager(manager);
//		Department dept=new Department();
//		dept.setDepartmentNumber(empDto.getDepartment_number());
//		employee.setDepartment(dept);
//		empRepo.save(employee);
		Employee employee=empMapper.maptoEntity(empDto);
		empRepo.save(employee);
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
