package com.afify.hr_system.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.mapper.dependent.DependentMapper;
import com.afify.hr_system.model.employee.EmpDTO;
import com.afify.hr_system.model.employee.Employee;

@Mapper(componentModel = "spring",uses = {DependentMapper.class})
public interface EmpMapper {
//	form entity to dto
	@Mappings({
		@Mapping(target = "first_name",source = "fname"),
		@Mapping(target = "last_name",source = "lname"),
		@Mapping(target = "birthdate",source = "bdate"),
		@Mapping(target = "manager_ssn",source = "manager.ssn"),
		@Mapping(target = "department_number",source = "department.departmentNumber")
		})
	EmpDTO empToDto(Employee emp);
// from dto to entity
	@Mappings(
			{
				@Mapping(source = "first_name",target = "fname"),
				@Mapping(source = "last_name",target = "lname"),
				@Mapping(source = "birthdate",target = "bdate"),
				@Mapping(source = "manager_ssn",target = "manager.ssn"),
				@Mapping(source = "department_number",target = "department.departmentNumber"),
				@Mapping(target = "dependents",ignore = true),
				@Mapping(target = "pouns",ignore = true),
			}
			 )
	Employee maptoEntity (EmpDTO empDto);
}
