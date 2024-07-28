package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceAlreadyExistsException;
import com.user.entity.AccountEntity;
import com.user.entity.LoginEntity;
import com.user.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    @Autowired
    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public AccountEntity createAccount(AccountEntity accountEntity) {
        validateUser(accountEntity);
        checkForExistingUser(accountEntity);
        return repo.save(accountEntity);
    }

    public void validateUser(AccountEntity accountEntity) {
        if (accountEntity.getName() == null || 
            accountEntity.getName().trim().isEmpty() || 
            accountEntity.getName().length() < 3 || 
            accountEntity.getName().length() > 50 || 
            !accountEntity.getName().matches("^[a-zA-Z\\s]+$")) {
            
            throw new IllegalArgumentException("Invalid account name. Name must be between 3 and 50 characters long and contain only alphanumeric characters and spaces.");
        }
    


        if (accountEntity.getEmail() == null || !accountEntity.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (accountEntity.getPhone() == null || !accountEntity.getPhone().matches("^\\d{10}$")) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }

        if (accountEntity.getPassword() == null || accountEntity.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        // Additional validations can be added as needed
    }

    public void checkForExistingUser(AccountEntity accountEntity) {
        if (repo.findByEmail(accountEntity.getEmail()) != null) {
            throw new ResourceAlreadyExistsException("User with this email already exists");
        }
        if (repo.findByPhone(accountEntity.getPhone()) != null) {
            throw new ResourceAlreadyExistsException("User with this phone number already exists");
        }
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
       
        return false;
    }

    @Override
    public boolean isUserExistsByPhone(String phone) {
        // Implementation needed
        return false;
    }

    @Override
    public boolean isUserExistsByEmail1(String email) {
        // Implementation needed
        return false;
    }

	@Override
	public LoginEntity findByEmail(LoginEntity loginEntity) {
		
		return null;
	}

	@Override
	public Optional<AccountEntity> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
    public Optional<AccountEntity> findByPhone(String phone) {
        // Find the account entity by phone
        Optional<AccountEntity> accountEntity = repo.findByPhone(phone);
        // Return the id if the account entity is present
        return Optional.empty();
    }
}


