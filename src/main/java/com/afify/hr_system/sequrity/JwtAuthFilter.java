package com.afify.hr_system.sequrity;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.afify.hr_system.error.TokenNotVaild;
import com.afify.hr_system.model.appUser.Token;
import com.afify.hr_system.repo.userAuth.TokenRepo;
import com.afify.hr_system.service.UserJwt.AppUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AppUserDetailsService userDetailsService;
    private final TokenRepo tokenRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        // Validate Authorization header format
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extract JWT and user email
        jwt = authHeader.substring(7);
//        Get Claim of subject from jwt
        userEmail = jwtService.extractUserEmail(jwt);
        
        // If user is not authenticated yet, process JWT
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//        	get from database may be exist or null
            UserDetails userDetails = this.userDetailsService.loadByUserName(userEmail);
            Token presistedToken=tokenRepo.findByToken(jwt);
//            if you have more than one token for same user only one is valid
            boolean prevTokenValid=!presistedToken.is_expired() && !presistedToken.is_revocked();
            if (jwtService.isTokenValid(jwt, userDetails) && prevTokenValid) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else {
            	throw new TokenNotVaild("Token is Not Valid");
            }
        }

        filterChain.doFilter(request, response);
    }
}

