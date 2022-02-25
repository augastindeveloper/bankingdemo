package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.repository.UserRepository;

@Controller
public class WithdrawController {
	
	@Autowired
    private UserRepository repo;
	
	@GetMapping("/withdraw")
	public String viewWithdrawPage() {
		return "withdraw";
		
	}

}
