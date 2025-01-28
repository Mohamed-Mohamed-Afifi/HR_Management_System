package com.afify.hr_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.afify.hr_system.controller.auth.AuthService;
import com.afify.hr_system.repo.userAuth.UserRepo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig {
//private final AppUserDetailsService userDetailsService;
	private final UserRepo userRepo;
//	Bean that provide the users
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		return username->userRepo.findByEmail(username);
	}
//	Bean than handle login take email and password and check authentication
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();	
	}
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args->{
//			var admin=RequestReg.builder()
//					.fullname("mohamedSamon")
//					.password("1020")
//					.role(Role.ADMIN)
//					.email("admin@gmail.com")
//					.build();
//			System.out.println("Admin Token :" +authService.register(admin).getToken());
//			
//			var manager=RequestReg.builder()
//					.fullname("mohamedrashdan")
//					.password("1020")
//					.role(Role.MANAGER)
//					.email("manager@gmail.com")
//					.build();
//			System.out.println("Admin Token :" +authService.register(manager).getToken());
//		};
//	}
	
}
