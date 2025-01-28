package com.afify.hr_system.service.UserJwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.afify.hr_system.repo.userAuth.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService {
public final UserRepo userRepo;

public UserDetails loadByUserName(String userName) {
	return userRepo.findByEmail(userName);
}
}
