package com.afify.hr_system.controller.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLogin {
	private String email;
	private String password;
}
