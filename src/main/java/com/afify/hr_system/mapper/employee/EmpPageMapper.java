package com.afify.hr_system.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.afify.hr_system.model.employee.EmpPageDto;
import com.afify.hr_system.model.employee.Employee;

@Mapper(componentModel = "spring",uses = {EmpMapper.class})
public interface EmpPageMapper {
	@Mappings({
			@Mapping(source="content",target = "employees"),
			@Mapping(expression = "java(empPage.getNumber())",target = "pageNumber"),
			@Mapping(expression = "java(empPage.getSize())",target = "pageSize"),
			@Mapping(expression = "java(empPage.getTotalPages())",target = "totalPages")
			})
	EmpPageDto map(Page<Employee> empPage);
}
