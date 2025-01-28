package com.afify.hr_system.controller.auth.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.service.UserJwt.AppUserDetailsService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
private final AppUserDetailsService appUserDetailsService;
	@GetMapping("{email}")
	public ResponseEntity<?> getUser(@PathVariable String email) {
		return ResponseEntity.ok(appUserDetailsService.loadByUserName(email));
	}
	
}
