package com.sismo.mx.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FAMILY")
public class UserFamily {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "FULLNAME", nullable = false)
	private String fullname;
	@Column(name = "CONTACTO", nullable = false)
	private Integer contacto;
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "AGE", nullable = false)
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
