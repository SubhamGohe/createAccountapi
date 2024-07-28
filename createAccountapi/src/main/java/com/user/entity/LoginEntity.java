package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	private String email;
	
	private String phone;

	public LoginEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginEntity(long id, String email, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
