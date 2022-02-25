package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.AccountDetails;
import com.entity.CustomUserDetails;
import com.repository.AccountDetailsRepository;
import com.repository.UserRepository;
@Controller
public class DepositController {
	@Autowired
	private AccountDetailsRepository repo;
	
	@GetMapping("/deposit")
	public String viewDepositPage() {
		return "deposit";
		
	}
	@GetMapping("/deposit/self")
	public String viewSelfDepositPage(Model model) {
		model.addAttribute("accountDetails", new AccountDetails());
		return "self_deposit";
		
	}
	@ResponseBody
	@PostMapping("/deposit/success")
	public String depositSuccess(AccountDetails accountDetails) {
		CustomUserDetails userinfo = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long id = userinfo.getId();
		accountDetails.getUserinfo().setId(id);
		repo.save(accountDetails);
		return "Deposit Success";
	}
	

}
