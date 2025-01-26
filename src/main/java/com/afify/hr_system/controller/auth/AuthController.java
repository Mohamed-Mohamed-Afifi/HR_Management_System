package com.afify.hr_system.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
private final AuthService authService;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RequestReg requReg){
		return authService.register(requReg);
	}
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody RequestLogin requReg){
		return authService.login(requReg);
	}
}
