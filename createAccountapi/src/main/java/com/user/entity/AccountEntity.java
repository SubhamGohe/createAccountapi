package com.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Table(name= "Account Create Table")
@Entity
public class AccountEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	//@NotBlank
	//@Column(name= "Account Holder" , nullable =false)
	//@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    //(regexp = "^[a-zA-Z\\s]*$", message = "Name must contain only alphabetic characters")
	private String name;
	

	///@NotBlank(message = "Email is required")
   // @Email(message = "Invalid email format")
   // @Column(name = "Email_Id", unique = true)
	private String email;
	
	
	//@NotBlank(message = "Phone number is required")
   //@Pattern(regexp = "^\\+?\\d{1,3}[- ]?\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone number format")
  //  @Column(name = "Phone_Number", unique = true)
    private String phone;
	
	
//	 @NotBlank(message = "Password is required")
	//    @Column(name = "Account_Password")
	    private String password;
	    
	
	
	
	public AccountEntity(long id, @NotBlank String name, @NotBlank String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
