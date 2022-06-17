package com.vladwick.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "User ID", example = "1", required = true) 
	private Long id;
	
	@Column(name="first_name")
	@ApiModelProperty(notes = "Name of the user", example = "Vlad", required = true) 
	private String firstName;
	
	@Column(name="last_name")
	@ApiModelProperty(notes = "Surname of the user", example = "Wick", required = true)
	private String lastName;
	
	@ApiModelProperty(notes = "Email of the user", example = "vladwick@gmail.com", required = true)
	private String email;
	
	@ApiModelProperty(notes = "Password of the user", example = "kngu76ehv_a", required = true)
	private String password;
	
	@Column(name="info")
	@ApiModelProperty(notes = "Information about user", example = "Sample text", required = true)
	private String info;
	
	@Column(name="balance")
	@ApiModelProperty(notes = "Balance of the user", example = "10900", required = true)
	private BigDecimal balance;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	@ApiModelProperty(notes = "Roles of the user", example = "USER", required = true)
	private Collection<Role> roles;
	
	public User() {
		
	}
	public User(String firstName, String lastName, String email, String info, BigDecimal balance, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.info = info;
		this.balance = balance;
		this.password = password;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
