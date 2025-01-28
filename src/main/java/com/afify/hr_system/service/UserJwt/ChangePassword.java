package com.afify.hr_system.service.UserJwt;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.afify.hr_system.controller.auth.passwordchange.PasswordRequest;
import com.afify.hr_system.error.PasswordIsNotCorrected;
import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.model.appUser.Token;
import com.afify.hr_system.repo.userAuth.TokenRepo;
import com.afify.hr_system.repo.userAuth.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangePassword {
	private final TokenRepo tokenRepo;
	private final  PasswordEncoder passwordEncoder;
	private final  UserRepo userRepo;
	@Transactional
	public ResponseEntity<?> changePass(PasswordRequest passwordRequest, Principal connectedUser) {
		AppUser user=(AppUser) ((UsernamePasswordAuthenticationToken)connectedUser).getPrincipal();
		if(!passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword())) {
			throw new PasswordIsNotCorrected("passowrd is not valid!");
		}
		if(!(passwordRequest.getNewPassword().equals(passwordRequest.getConfiPassword()))) {
			throw new PasswordIsNotCorrected("passowrd is not valid!");
		}
//		after change password set token to be none valid to ensure to login in with new password
		user.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
		userRepo.save(user);
		List<Token>tokens=tokenRepo.findValidTokenUserId(user.getId());
		tokens.forEach(token->{
			token.set_expired(true);
			token.set_revocked(true);
		}
		);
		return ResponseEntity.accepted().body("Changed");
	}
	
}
