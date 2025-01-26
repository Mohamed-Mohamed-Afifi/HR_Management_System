package com.afify.hr_system.sequrity;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        // Validate Authorization header format
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	System.out.println("hi");
            filterChain.doFilter(request, response);
            return;
        }

        // Extract JWT and user email
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(jwt);

        // If user is not authenticated yet, process JWT
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        	System.out.println("hi2");
            UserDetails userDetails = this.userDetailsService.loadByUserName(userEmail);

            if (jwtService.isTokenValid(jwt, userDetails)) {
            	System.out.println("hi3");
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

