package com.sismo.mx.rest.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AppUserVO {

	private String email;
	@NotBlank
	@NotNull
	private String username;
	@NotBlank
	@NotNull
	private String password;
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
