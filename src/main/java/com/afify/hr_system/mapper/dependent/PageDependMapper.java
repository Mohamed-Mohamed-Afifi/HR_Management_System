package com.afify.hr_system.mapper.dependent;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.PageDepenDto;

@Mapper(componentModel = "spring",uses = {DependentMapper.class})
public interface PageDependMapper {

	@Mappings({
		@Mapping(source = "content",target = "dependents"),
		@Mapping(expression = "java(denPage.getNumber())",target = "page_number"),
		@Mapping(expression = "java(denPage.getSize())",target = "page_size"),
		@Mapping(expression = "java(denPage.getTotalPages())",target = "totalPages")
	})
	PageDepenDto map(Page<Dependent> denPage);
}
