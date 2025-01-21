package com.afify.hr_system.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.mapper.dependent.DependentMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.Employee;

@Mapper(componentModel = "spring",uses = {DependentMapper.class})
public interface EmpMapper {
//	form entity to dto
	@Mappings({
		@Mapping(target = "full_name", expression = "java(emp.getFname() + \" \" + emp.getLname())"),
		@Mapping(target = "birthdate",source = "bdate"),
		@Mapping(target = "manager_ssn",source = "manager.ssn"),
		@Mapping(target = "department_number",source = "department.departmentNumber")
		
		})
	EmpDTO empToDto(Employee emp);
// from dto to entity
	@Mappings(
			{
				@Mapping(expression="java(empDto.getFull_name().split(\" \")[0])",target = "fname"),
				@Mapping(expression = "java(empDto.getFull_name().split(\" \").length > 1 ? empDto.getFull_name().split(\" \")[1] : \"\")",target = "lname"),
				@Mapping(source = "birthdate",target = "bdate"),
				@Mapping(target = "manager",expression = "java(mapManager(empDto.getManager_ssn()))"),
				@Mapping(target = "department",expression = "java(mapDepartment(empDto.getDepartment_number()))"),
				@Mapping(target = "dependents",ignore = true),
				@Mapping(target = "pouns",ignore = true),
//				@Mapping(source = "first_name",target = "fname"),
//				@Mapping(source = "last_name",target = "lname"),
//				@Mapping(source = "birthdate",target = "bdate"),
//				@Mapping(source = "manager_ssn",target = "manager.ssn"),
//				@Mapping(source = "department_number",target = "department.departmentNumber")
				
			}
			 )
	Employee maptoEntity (EmpDTO empDto);

default Employee mapManager(Integer managerSsn) {
    if (managerSsn == null)
		return null;
	else {
		Employee emp=new Employee();
		emp.setSsn(managerSsn);
		return emp;
	}
}

default Department mapDepartment(Integer departmentNumber) {
    if (departmentNumber == null)
		return null;
	else {
		Department dept=new Department();
		dept.setDepartmentNumber(departmentNumber);
		return dept;
	}
}
//default String FirstNa(String fullName) {
//    return fullName.split(" ")[0]; // Assumes first name is the first part
//}
//
//default String LastNa(String fullName) {
//    String[] parts = fullName.split(" ");
//    return parts.length > 1 ? parts[1] : ""; // Assumes last name is the second part
//}
}
