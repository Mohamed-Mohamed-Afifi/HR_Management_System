package com.afify.hr_system.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.mapper.project.ProjectMapper;
import com.afify.hr_system.model.department.DepartDto;
import com.afify.hr_system.model.department.Department;

@Mapper(componentModel = "spring",uses = {EmpMapper.class,ProjectMapper.class})
public interface DeptMapper {
	@Mappings({
		@Mapping(source = "dnum",target = "departmentNumber"),
		@Mapping(source = "supervisorSsn",target = "supervisor.ssn"),
		@Mapping(target = "numOfEmp",ignore = true)
		
			 })
	Department umMap(DepartDto departDto);
	@Mappings({
		@Mapping(target = "dnum",source = "departmentNumber"),
		@Mapping(target = "supervisorSsn", expression = "java(dept.getSupervisor() != null ? dept.getSupervisor().getSsn() : null)"),
		@Mapping(target = "supervisorName", expression = "java(dept.getSupervisor() != null ? dept.getSupervisor().getFname() + \" \" + dept.getSupervisor().getLname() : \"No Supervisor\")"),
		@Mapping(target = "employees",ignore = true),
		@Mapping(target="projects",ignore = true)
			 })
	DepartDto map(Department dept);
}
