package com.afify.hr_system.controller.auth.passwordchange;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afify.hr_system.service.UserJwt.ChangePassword;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/changepassword")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ChangePasswordController {
	private final ChangePassword changePassword;
	@PatchMapping("")
	public ResponseEntity<?> changePassword(@RequestBody PasswordRequest passwordRequest,Principal connectedUser){
		return changePassword.changePass(passwordRequest,connectedUser);
	}
}
