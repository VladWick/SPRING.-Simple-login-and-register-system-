package com.vladwick.model;

import java.math.BigDecimal;
import java.util.Collection;

public class UserRegistrationDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String info;
	private BigDecimal balance;
	private String password;
	
	private Collection<Role> roles;
	
	public UserRegistrationDto() {
		
	}
	public UserRegistrationDto(String firstName, String lastName, String email, String info, BigDecimal balance, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.info = info;
		this.balance = balance;
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}