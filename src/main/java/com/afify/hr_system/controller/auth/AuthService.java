package com.afify.hr_system.controller.auth;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.user.UserDto;
import com.afify.hr_system.mapper.user.UserMapper;
import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.model.appUser.Role;
import com.afify.hr_system.model.appUser.Token;
import com.afify.hr_system.repo.userAuth.TokenRepo;
import com.afify.hr_system.repo.userAuth.UserRepo;
import com.afify.hr_system.sequrity.JwtService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final TokenRepo tokenRepo;
	private final UserMapper userMapper;
	@Transactional
	public ResponseEntity<?> register(RequestReg reqReg) {
		AppUser user=new AppUser();
		user.setFullName(reqReg.getFullname());
		user.setEmail(reqReg.getEmail());
		user.setRole(reqReg.getRole());
		user.setPassword(passwordEncoder.encode(reqReg.getPassword()));
		userRepo.save(user);
		final String jwt=jwtService.generateToken(user);
		AppUser presistedUser=userRepo.findByEmail(user.getUsername());
		revokePrevTokens(presistedUser);
		saveToken(presistedUser, jwt);
		ResponseAuth responseAuth=new ResponseAuth();
		UserDto userdto=userMapper.map(user);
		responseAuth.setUser(userdto);
		responseAuth.setToken(jwt);
		return ResponseEntity.ok(responseAuth);
	}
	private void saveToken(AppUser user, final String jwt) {
		Token token=new Token();
		token.set_expired(false);
		token.set_revocked(false);
		token.setUser(user);
		token.setToken(jwt);
		tokenRepo.save(token);
	}
	private void revokePrevTokens(AppUser user) {
		List<Token> allPrevTokens=tokenRepo.findValidTokenUserId(user.getId());
		allPrevTokens.forEach(tkn->{
			tkn.set_expired(true);
			tkn.set_revocked(true);
		});
		tokenRepo.saveAll(allPrevTokens);
	}
	@Transactional
	public ResponseEntity<?> login(RequestLogin requestLogin) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						requestLogin.getEmail(),
						requestLogin.getPassword()
						)
					);
		AppUser user=userRepo.findByEmail(requestLogin.getEmail());
		final String jwt=jwtService.generateToken(user);
		revokePrevTokens(user);
		saveToken(user, jwt);
		ResponseAuth responseAuth=new ResponseAuth();
		UserDto userdto=userMapper.map(user);
		responseAuth.setUser(userdto);
		responseAuth.setToken(jwt);
		return ResponseEntity.ok(responseAuth);
	}
}
