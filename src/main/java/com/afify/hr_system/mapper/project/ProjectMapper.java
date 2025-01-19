package com.afify.hr_system.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectDto;

@Mapper(componentModel = "spring",uses = {EmpMapper.class})
public interface ProjectMapper {
	@Mappings({
			@Mapping(source = "projectId",target = "pnum"),
			@Mapping(source = "projectName",target = "pname"),
			@Mapping(source = "departmentNumber",target = "department.departmentNumber"),
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
}
