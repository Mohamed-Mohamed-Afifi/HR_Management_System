package com.afify.hr_system.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.mapper.department.DeptMapper;
import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectDto;

@Mapper(componentModel = "spring",uses = {EmpMapper.class,DeptMapper.class})
public interface ProjectMapper {
	@Mappings({
			@Mapping(source = "projectId",target = "pnum"),
			@Mapping(source = "projectName",target = "pname"),
			@Mapping(expression = "java(mapDepartment(projectDto.getDepartmentNumber()))",target = "department"),
			@Mapping(source = "employees",target = "employees")
			  })
	Project unmaped(ProjectDto projectDto);
	@Mappings({
		@Mapping(target = "projectId",source = "pnum"),
		@Mapping(target = "projectName",source = "pname"),
		@Mapping(target = "departmentNumber",source = "department.departmentNumber"),
		@Mapping(target = "employees",source = "employees")
		  })
	ProjectDto map(Project project);
	
	default Department mapDepartment(Integer dnum) {
		if(dnum==null) {
			return null;
		}else {
			Department dept=new Department();
			dept.setDepartmentNumber(dnum);
			return dept;
		}
	}
}
