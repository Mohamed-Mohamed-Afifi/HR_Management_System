package com.afify.hr_system.model.appUser.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TokenDto {
	private String accessToken;
	private LocalDate expiration_date;
	private boolean is_valid;
}
