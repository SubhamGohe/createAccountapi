package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceAlreadyExistsException;
import com.service.AccountService;
import com.user.entity.AccountEntity;
import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //localhost:8080/findByEmail
    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        Optional<AccountEntity> account = accountService.findByEmail(email);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
    }  
    //http://localhost:8080/findByPhone?phone=1234567890.
  //localhost:8080/findByPhone
    @GetMapping("/findByPhone")
    public ResponseEntity<?> findByPhone(@RequestParam String phone) {
        Optional<AccountEntity> account = (Optional<AccountEntity>) accountService.findByPhone(phone);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
    }

    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody AccountEntity accountEntity) {
        try {
            accountService.createAccount(accountEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
        } catch (ResourceAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}






//package com.controller;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exception.ResourceAlreadyExistsException;
//import com.service.AccountService;
//
//import com.user.entity.AccountEntity;
//import com.user.repository.AccountRepository;
//
//
//import jakarta.persistence.Column;
//import jakarta.validation.constraints.NotBlank;
//
//@RestController
//public class AccountController {
//	 @Autowired
//	private AccountService accountService;
//	 @Autowired
//	 private AccountRepository repo;
//	
//	 
//	
//	//localhost:8080/createAccount
//		@PostMapping("/createAccount")
//	  public  ResponseEntity<String>  createAccount(@RequestBody AccountEntity accountEntity)
//	     {
//			
//			System.out.println(accountEntity);
//			
//			 try {
//		            accountService.createAccount(accountEntity);
//		            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
//		        } 
//			 catch (ResourceAlreadyExistsException ex) {
//		            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//		        } 
////			 catch (Exception ex) {
////		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
////		        }		 		
//			
//			 @GetMapping("/findByEmail")
//			    public ResponseEntity<?> findByEmail(@RequestParam String email) {
//			        Optional<AccountEntity> account = accountService.findByEmail(email);
//			        if (account.isPresent()) {
//			            return ResponseEntity.ok(account.get());
//			        } else {
//			            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
//			        }}
		
//		//localhost:8080/Login
//		@PostMapping("/Login")
//    public AccountEntity Login() {
//			
//	AccountEntity findByEmail = repo.findByEmail(accountEntity.getEmail());
//	
//	AccountEntity findByPhone = repo.findByPhone(accountEntity.getPhone());
//	
//}
//
//}
			
//			//check the email id 
//		if (findByEmail != null) {
//	            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists");
//	        }
//		
//		if (findByPhone != null) {
//		            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this phone number already exists");
//		        }
//		accountService.createAccount(accountEntity);
//		
//			
//		return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
//		 
//	     }
	
	
//}


////localhost:8080/create/10/java
// //pathvariable
//@PostMapping("/create/{id}/{name}")
//public String  pathvariable( @PathVariable ("id") int id, 
//		                       @PathVariable("name") String name) 
//{
//	 System.out.println(id);
//	 System.out.println(name);
//	 return  name;
//}
////localhost:8080/create
// //Requestparam
//@PostMapping("/create")
//public int  requestParam( @RequestParam ("id") int userId,
//		                   @RequestParam ("name")String username )
//{
//	 System.out.println(username);
//	 return  userId;
//}
//
////localhost:8080/modelAttribute
//@PostMapping("/modelAttribute")
//public Account modelAttribute(@ModelAttribute  Account account) 
//{
//	 System.out.println(account);
//	 
//	 return account;
//}
//
////localhost:8080/requestbody
//@PostMapping("/requestbody")
//public Account requestBody(@RequestBody  Account account) 
//{
//	 System.out.println(account);
//	 
//	 return account;
//}

