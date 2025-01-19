package com.afify.hr_system.mapper.dependent;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.model.dependent.Dependent;
import com.afify.hr_system.model.dependent.DependentDto;

@Mapper(componentModel = "spring")
public interface DependentMapper {
	
	@Mappings({
				@Mapping(target="employeeSsn",source="dependentId.employee.ssn"),
				@Mapping(target="dependentName",source="dependentId.depname")
			 })
	DependentDto map(Dependent depn);
	@Mappings({
		@Mapping(source="employeeSsn",target="dependentId.employee.ssn"),
		@Mapping(source="dependentName",target="dependentId.depname")
	 })
	Dependent unmap (DependentDto depnDto);
	
}
