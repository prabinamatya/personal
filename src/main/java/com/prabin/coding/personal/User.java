package com.prabin.coding.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "app_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1390177847091012107L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 3, message = "Username must be more than 3 characters!")
	@Column(unique = true)
	private String name;
	
	@Size(min = 3, message = "Invalid email!")
	@Email(message = "Invalid email!")
	private String email;
	
	@Size(min = 5, message = "Password must be at least 5 characters")
	private String password;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
