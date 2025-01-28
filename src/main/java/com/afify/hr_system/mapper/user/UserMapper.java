package com.afify.hr_system.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.afify.hr_system.model.appUser.AppUser;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto map(AppUser user);
	

	AppUser unmap(UserDto userDto);
}
