package com.afify.hr_system.controller.auth.passwordchange;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordRequest {
	private String oldPassword;
	private String newPassword;
	private String confiPassword;
}
