package com.sismo.mx.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sismo.mx.commons.AppUserService;
import com.sismo.mx.commons.dto.AppUserDTO;
import com.sismo.mx.commons.dto.EmailDTO;
import com.sismo.mx.commons.dto.FamiliarDTO;
import com.sismo.mx.commons.exception.ForbiddenException;
import com.sismo.mx.commons.exception.NotFoundException;
import com.sismo.mx.persistence.AppUserDAO;
import com.sismo.mx.persistence.UserFamilyDAO;
import com.sismo.mx.persistence.entities.AppUser;
import com.sismo.mx.persistence.entities.UserFamily;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{
	
	private static final Logger logger = Logger.getLogger(AppUserService.class);

	@Autowired private AppUserDAO appUserDAO;
	@Autowired private JavaMailSender javaMailSender;
	@Autowired private UserFamilyDAO userFamilyDAO;
	
	@Override
	public List<AppUserDTO> getAllAppUsers() {
		logger.info("SERVICE: getAllAppUsers method");
		
		List<AppUser> appUsers = this.appUserDAO.getAll();
		List<AppUserDTO> appUserDTOs = new ArrayList<>();
		
		appUsers.stream().forEach(user -> {
			AppUserDTO appUserDTO = new AppUserDTO();
			appUserDTO.setEmail(user.getEmail());
			appUserDTO.setUsername(user.getUsername());
			appUserDTO.setPassword(user.getPassword());
			appUserDTO.setIsAdmin(user.getIsAdmin());
			appUserDTOs.add(appUserDTO);
		});
		
		return appUserDTOs;
	}

	@Override
	public void sendEmail(EmailDTO dto) throws MessagingException {
		logger.info("SERVICE: sendEmail method");
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true indicates
										// multipart message
		logger.info(dto.getSubject());
		logger.info(dto.getTo());
		logger.info(dto.getBody());
		helper.setSubject(dto.getSubject());
		helper.setTo(dto.getTo());
		helper.setText(dto.getBody(), true); // true indicates html
		// continue using helper object for more functionalities like adding attachments, etc.  
		
		logger.info(message.getFrom());
		javaMailSender.send(message);
		logger.info("paso");
	}

	@Override
	public Integer createFamiliar(FamiliarDTO dto) {
		logger.info("SERVICE: createFamiliar method");
		
		UserFamily family = new UserFamily();
		family.setContacto(dto.getContacto());
		family.setEmail(dto.getEmail());
		family.setFullname(dto.getFullname());
		family.setImage(dto.getImage());
		
		Integer id = (Integer) this.userFamilyDAO.create(family);
		return id;
	}

	@Override
	public List<FamiliarDTO> getAllFamilies() {
		logger.info("SERVICE: getAllFamilies method");
		
		List<FamiliarDTO> dtos = new ArrayList<>();
		List<UserFamily> families = this.userFamilyDAO.getAll();
		
		families.stream().forEach(familiar -> {
			FamiliarDTO dto = new FamiliarDTO();
			dto.setContacto(familiar.getContacto());
			dto.setEmail(familiar.getEmail());
			dto.setFullname(familiar.getFullname());
			dto.setImage(familiar.getImage());
			dto.setId(familiar.getId());
			dtos.add(dto);
			
		});
		
		return dtos;
	}

	@Override
	public FamiliarDTO getFamiliarDetails(Integer id) throws NotFoundException{
		logger.info("SERVICE: getFamiliarDetails method");
		
		FamiliarDTO dto = new FamiliarDTO();
		UserFamily family = this.userFamilyDAO.getById(id);
		
		if(family == null)
			throw new NotFoundException("Familiar with id : " + id + "not found");
		
		dto.setContacto(family.getContacto());
		dto.setEmail(family.getEmail());
		dto.setFullname(family.getFullname());
		dto.setImage(family.getImage());
		dto.setId(family.getId());
		
		return dto;
		
	}

	@Override
	public void login(AppUserDTO dto) throws ForbiddenException {
		Boolean isSignIn = this.appUserDAO.isSignIn(dto.getUsername());
		if(isSignIn){
			throw new ForbiddenException("No registrado");
		}
		
	}

}
