package com.afify.hr_system.model.appUser.dto;

import java.util.List;

import com.afify.hr_system.mapper.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPageDto {
	private List<UserDto> users;
	private int page_number;
	private int page_size;
	private int totalPages;
}
