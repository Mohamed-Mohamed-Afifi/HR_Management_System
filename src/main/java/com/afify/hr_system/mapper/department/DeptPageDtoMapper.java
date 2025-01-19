package com.afify.hr_system.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.afify.hr_system.model.department.Department;
import com.afify.hr_system.model.department.PageDeptDto;

@Mapper(componentModel = "spring",uses = {DeptMapper.class})
public interface DeptPageDtoMapper {
	@Mappings({
        @Mapping(source = "content", target = "departments"),
        @Mapping(expression = "java(page.getNumber())", target = "page_number"),
        @Mapping(expression = "java(page.getSize())", target = "page_size"),
        @Mapping(expression = "java(page.getTotalPages())", target = "totalPages")
	})
	PageDeptDto map(Page<Department> page);
}
