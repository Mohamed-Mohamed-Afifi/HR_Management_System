package com.afify.hr_system.mapper.user;

import com.afify.hr_system.model.appUser.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String email;
	private String fullName;
	private Role role;
}
