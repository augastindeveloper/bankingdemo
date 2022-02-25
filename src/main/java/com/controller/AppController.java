package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.AccountDetails;
import com.entity.CustomUserDetails;
import com.entity.UserInfo;
import com.repository.AccountDetailsRepository;
import com.repository.UserRepository;

@Controller
public class AppController {
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
		
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("userinfo", new UserInfo());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(UserInfo userinfo) {
		AccountDetails accountDetails = new AccountDetails();
		userinfo.setPassword(bcrypt.encode(userinfo.getPassword()));
		accountDetails.setAmount((long) 350000);
		accountDetails.setUserinfo(userinfo);
	//	repo.save(userinfo);
		accountDetailsRepository.save(accountDetails);
		return "register_success";
		
	}
	
	@GetMapping("/welcome")
	public ModelAndView welcome(Model model) {
	//	model.addAttribute("user","augustin");
		ModelAndView modelview = new ModelAndView("welcome");
	//	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userinfo = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name=userinfo.getFirstName();
		
		modelview.addObject("user",name);
	//	modelview.addObject("accountnumber",userinfo.getAccountNumber());
		return modelview;
	}

}
