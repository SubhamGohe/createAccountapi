package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.AccountService;
import com.user.entity.AccountEntity;
import com.user.entity.LoginEntity;

@RestController
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/Login")
	public String Login(@RequestBody LoginEntity loginEntity) 
	
	{
		
		accountService.findByEmail(loginEntity);
		
		return"null";
	}

}
