package com.afify.hr_system.controller.auth;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLogin {
	@Email
	private String email;
	private String password;
}
