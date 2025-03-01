package com.afify.hr_system.controller.auth.user;

import java.security.Principal;

import com.afify.hr_system.model.appUser.filter.UserSearchKeys;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.afify.hr_system.mapper.user.UserDto;
import com.afify.hr_system.service.UserJwt.AppUserDetailsService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
private final AppUserDetailsService appUserDetailsService;
	@GetMapping("{email}")
	public ResponseEntity<?> getUser(@PathVariable String email) {
		return ResponseEntity.ok(appUserDetailsService.loadByUserName(email));
	}
	@PreAuthorize("hasAuthority('admin:read')")
	@GetMapping("")
	public ResponseEntity<?> getAllusers(@RequestParam("page_number") int pageNum,@RequestParam("page_size") int pageSize){
		return ResponseEntity.ok(appUserDetailsService.getAllusers(pageNum,pageSize));
	}	@PreAuthorize("hasAuthority('admin:read')")
	@PostMapping("/filter")
	public ResponseEntity<?> filterusers(@RequestBody UserSearchKeys userSearchKeys){
		return appUserDetailsService.filter(userSearchKeys);
	}
	@PreAuthorize("hasAuthority('user:update')")
	@PutMapping("")
	public ResponseEntity<?> updateUser(@RequestBody UserDto user){
		return appUserDetailsService.updateUser(user);
	}
	@PreAuthorize("hasAuthority('user:update')")
	@PutMapping("/edit")
	public ResponseEntity<?> editSingleUser(@RequestBody UserDto user,Principal connendtedUser){
		return appUserDetailsService.editUser(user,connendtedUser);
	}
	@PreAuthorize("hasAuthority('admin:update')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return appUserDetailsService.deleteUser(id);
	}
	
}
