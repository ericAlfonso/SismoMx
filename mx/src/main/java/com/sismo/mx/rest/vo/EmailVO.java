package com.sismo.mx.rest.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class EmailVO {

	@NotNull
	@NotBlank
	private String to;
	@NotNull
	@NotBlank
	private String subject;
	@NotNull
	@NotBlank
	private String body;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
