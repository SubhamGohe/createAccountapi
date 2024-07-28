package com.service;


import java.util.Optional;

import com.user.entity.AccountEntity;
import com.user.entity.LoginEntity;

public interface AccountService {
	 public AccountEntity createAccount(AccountEntity accountEntity);
	 
	 boolean  isUserExistsByEmail(String email);

	 boolean  isUserExistsByPhone(String phone);

	boolean isUserExistsByEmail1(String email);

	void validateUser(AccountEntity accountEntity);
	
	
	//login Account

	public LoginEntity findByEmail(LoginEntity loginEntity);

	public Optional<AccountEntity> findByEmail(String email);

	public Optional<AccountEntity> findByPhone(String phone);
	 
	 
}
