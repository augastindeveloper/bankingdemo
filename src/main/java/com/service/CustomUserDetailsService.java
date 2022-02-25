package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.entity.CustomUserDetails;
import com.entity.UserInfo;
import com.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserInfo user = repo.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetails(user);
	}

}
