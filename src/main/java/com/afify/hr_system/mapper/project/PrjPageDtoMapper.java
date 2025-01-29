package com.afify.hr_system.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.afify.hr_system.mapper.employee.EmpMapper;
import com.afify.hr_system.model.projects.Project;
import com.afify.hr_system.model.projects.ProjectPageDto;

@Mapper(componentModel = "spring",uses = {ProjectMapper.class,EmpMapper.class})
public interface PrjPageDtoMapper {

	@Mappings({
		@Mapping(source = "content",target = "projects"),
		@Mapping(expression = "java(prjPage.getNumber())",target = "pageNumber"),
		@Mapping(expression = "java(prjPage.getSize())",target = "pageSize"),
		@Mapping(expression = "java(prjPage.getTotalPages())",target = "totalPages")
	})
	ProjectPageDto map(Page<Project> prjPage);
}
