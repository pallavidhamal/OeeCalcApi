package com.oee.security;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.oee.serviceimpl.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class AuthTokenFilter  extends OncePerRequestFilter {


	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	JwtUtils jwtUtils ;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			
			  if (jwt != null) { 
				  
				  String username =  jwtUtils.getUserNameFromJwtToken(jwt);
				  Authentication authentication
					            = SecurityContextHolder.getContext().getAuthentication();
			
		        if(username !=null  && authentication == null) {
				  UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				  
				  if(jwtUtils.isTokenValid(jwt,userDetails)) {

						  UsernamePasswordAuthenticationToken authenticationToken 
						  		= new UsernamePasswordAuthenticationToken( userDetails, null,userDetails.getAuthorities()); 
						  authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						  
						  SecurityContextHolder.getContext().setAuthentication(authenticationToken); 
					  }
				  }
			  }
			 
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader(SecurityConstants.HEADER_STRING);

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
