package com.afify.hr_system.sequrity;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.afify.hr_system.model.appUser.AppUser;

public class AuthenticationAware implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null||!authentication.isAuthenticated()||authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();			
		}
	 AppUser connectedUser=(AppUser)authentication.getPrincipal();
	 return Optional.ofNullable(connectedUser.getEmail());
	}
	

}
