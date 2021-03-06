package com.sismo.mx.commons.dto;

public class AppUserDTO {

	private String email;
	private String username;
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
