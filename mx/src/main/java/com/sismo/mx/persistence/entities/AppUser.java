package com.sismo.mx.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class AppUser {

	@Id
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "IS_ADMIN", nullable = false)
	private Long isAdmin;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Long isAdmin) {
		this.isAdmin = isAdmin;
	}
}
