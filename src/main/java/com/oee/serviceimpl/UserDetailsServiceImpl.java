package com.oee.serviceimpl;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oee.entity.UserInfoEntity;
import com.oee.repository.UserInfoRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
//	UserRepository userRepository;
	UserInfoRepository	empInfoRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfoEntity user = empInfoRepository.findByUsername(username);

		return UserDetailsImpl.build(user);
	}

}