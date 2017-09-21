package com.sismo.mx.rest.vo;

import javax.validation.constraints.NotNull;

public class FamiliarVO {
	
	private Integer id;
	@NotNull
	private String email;
	@NotNull
	private String fullname;
	@NotNull
	private Integer contacto;
	private String image;
	@NotNull
	private Integer age;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getContacto() {
		return contacto;
	}
	public void setContacto(Integer contacto) {
		this.contacto = contacto;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
