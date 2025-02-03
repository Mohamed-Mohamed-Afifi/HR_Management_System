package com.afify.hr_system.service.UserJwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.afify.hr_system.mapper.user.UserDto;
import com.afify.hr_system.mapper.user.UserMapper;
import com.afify.hr_system.model.appUser.AppUser;
import com.afify.hr_system.repo.userAuth.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService {
public final UserRepo userRepo;
public final UserMapper userMapper;

public UserDetails loadByUserName(String userName) {
	return userRepo.findByEmail(userName);
}
public List<UserDto> getAllusers(){
	List<AppUser> users=userRepo.findAll();;
	List<UserDto> usersDto=users.stream().map(userMapper::map).collect(Collectors.toList());
	return usersDto;
} 
}
