package com.afify.hr_system.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
private final AuthService authService;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RequestReg requReg){
		return authService.register(requReg);
	}
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody @Valid RequestLogin requReg){
		return authService.login(requReg);
	}
}
