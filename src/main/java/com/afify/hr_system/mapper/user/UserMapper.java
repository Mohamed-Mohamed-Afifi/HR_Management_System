package com.afify.hr_system.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.afify.hr_system.model.appUser.AppUser;
import java.util.Base64;
@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mapping(target = "profileimg", expression = "java(convertImageToBase64(user.getImage()))")
	UserDto map(AppUser user);
	
	AppUser unmap(UserDto userDto);
	// Add this helper method to your mapper class
	default String convertImageToBase64(byte[] imageData) {
	    if (imageData == null || imageData.length == 0) {
	        return null;
	    }
	    return Base64.getEncoder().encodeToString(imageData);
	}
}
