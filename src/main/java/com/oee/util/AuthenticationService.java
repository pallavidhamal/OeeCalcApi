package com.oee.util;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.oee.serviceimpl.UserDetailsImpl;

public class AuthenticationService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	public static String getUserDetailsAfterLogin() {
		logger.info("----- AuthenticationService getUserDetailsAfterLogin -----");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		logger.info("UserDetails :---- " + userDetails);
		
		return userDetails.getUsername();
				
	}

}
