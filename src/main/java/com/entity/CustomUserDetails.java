package com.entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    @Autowired
	private UserInfo userinfo;
    
//	@Autowired
  //  private AccountDetails accountDetails;
	public CustomUserDetails(UserInfo userinfo) {
		
		this.userinfo = userinfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {		
		return userinfo.getPassword();
	}

	@Override
	public String getUsername() {		
		return userinfo.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		 
		return true;
	}

	@Override
	public boolean isEnabled() {		
		return true;
	}
	
	public String getFirstName() {
		return userinfo.getFirstName();
	}
	public Long getId() {
		return userinfo.getId();
	}
	
//	public Long getAccountNumber() {
//		return accountDetails.getAccountNumber();
//	}

}
