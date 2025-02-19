package com.afify.hr_system.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.model.appUser.dto.UserPageDto;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface userPageMapper {
	
	@Mappings({
		@Mapping(source = "content",target = "users"),
		@Mapping(target = "page_number",expression = "java(user.getNumber())"),
		@Mapping(target = "page_size",expression = "java(user.getSize())"),
		@Mapping(target = "totalPages",expression = "java(user.getTotalPages())"),
	})
	UserPageDto map(Page<AppUser> user);
}
