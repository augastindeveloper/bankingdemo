package com.security;

//import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.service.CustomUserDetailsService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private DataSource datasource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	} 
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return  NoOpPasswordEncoder.getInstance();
//	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authprovider= new DaoAuthenticationProvider();
		authprovider.setUserDetailsService(userDetailsService());
		authprovider.setPasswordEncoder(passwordEncoder());
		
		return authprovider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/welcome").authenticated()
		    .anyRequest().permitAll()
		    .and()
		    .formLogin()
		    .usernameParameter("email").passwordParameter("password")
		    .defaultSuccessUrl("/welcome")
		    .permitAll()
		    .and()
		    .logout().logoutSuccessUrl("/").permitAll();
	}
	
}
