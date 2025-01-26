package com.afify.hr_system.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.model.appUser.Role;
import com.afify.hr_system.repo.userAuth.UserRepo;
import com.afify.hr_system.sequrity.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	public ResponseEntity<?> register(RequestReg reqReg) {
		AppUser user=new AppUser();
		user.setFullName(reqReg.getFullname());
		user.setUserName(reqReg.getEmail());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(reqReg.getPassword()));
		userRepo.save(user);
		final String jwt=jwtService.generateToken(user);
		ResponseAuth responseAuth=new ResponseAuth();
		responseAuth.setToken(jwt);
		return ResponseEntity.ok(responseAuth);
	}
	public ResponseEntity<?> login(RequestLogin requestLogin) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						requestLogin.getEmail(),
						requestLogin.getPassword()
						)
					);
		AppUser user=userRepo.findByUserName(requestLogin.getEmail());
		final String jwt=jwtService.generateToken(user);
		ResponseAuth responseAuth=new ResponseAuth();
		responseAuth.setToken(jwt);
		return ResponseEntity.ok(responseAuth);
	}
}
