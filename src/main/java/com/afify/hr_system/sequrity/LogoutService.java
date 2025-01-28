package com.afify.hr_system.sequrity;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.afify.hr_system.error.TokenNotVaild;
import com.afify.hr_system.model.appUser.Token;
import com.afify.hr_system.repo.userAuth.TokenRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler{
private final TokenRepo tokenRepo;
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        // Extract JWT and user email
        // Validate Authorization header format
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	return;
        }
        	jwt = authHeader.substring(7);
        	Token tkn=tokenRepo.findByToken(jwt);
        	if(tkn!=null) {
        		tkn.set_expired(true);
        		tkn.set_revocked(true);
        		tokenRepo.save(tkn);
        	}else {
        		throw new TokenNotVaild("token not exist");
        	}
        	
        }
		
	}

