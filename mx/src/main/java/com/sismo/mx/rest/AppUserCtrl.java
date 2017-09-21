package com.sismo.mx.rest;

import javax.mail.MessagingException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.sismo.mx.rest.vo.AppUserVO;
import com.sismo.mx.rest.vo.EmailVO;
import com.sismo.mx.rest.vo.FamiliarVO;

@SuppressWarnings("rawtypes")
public interface AppUserCtrl {

	ResponseEntity getAllAppUsers();
	ResponseEntity sendEmail(EmailVO emailVO, BindingResult bindingResult) throws MessagingException;
	ResponseEntity createFamiliar(FamiliarVO familiarVO, BindingResult bindingResult);
	ResponseEntity getAllFamilies();
	ResponseEntity getFamilyDetails(Integer id);
	ResponseEntity login(AppUserVO appUserVO, BindingResult bindingResult);
	ResponseEntity getFamiliarByName(String name);
 }
