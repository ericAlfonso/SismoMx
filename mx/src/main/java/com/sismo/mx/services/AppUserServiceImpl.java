package com.sismo.mx.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.sismo.mx.persistence.UserInfoDAO;
import com.sismo.mx.persistence.entities.AppUser;
import com.sismo.mx.persistence.entities.UserFamily;
import com.sismo.mx.persistence.entities.UserInfo;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{
	
	private static final Logger logger = Logger.getLogger(AppUserService.class);

	@Autowired private AppUserDAO appUserDAO;
	@Autowired private UserFamilyDAO userFamilyDAO;
	@Autowired private UserInfoDAO userInfoDAO;
	
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
	public void saveInfo(EmailDTO dto) throws MessagingException {
		logger.info("SERVICE: saveInfo method");
		
		String info = dto.getTo() + dto.getSubject() + dto.getBody();
		UserInfo userInfo = new UserInfo();
		userInfo.setInfo(info);
		Integer id = (Integer) this.userInfoDAO.create(userInfo);
		logger.info("Info created : " + id);
	}

	@Override
	public Integer createFamiliar(FamiliarDTO dto) {
		logger.info("SERVICE: createFamiliar method");
		
		UserFamily family = new UserFamily();
		family.setContacto(dto.getContacto());
		family.setEmail(dto.getEmail());
		family.setFullname(dto.getFullname());
		family.setImage(dto.getImage());
		family.setAge(dto.getAge());
		
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
			dto.setAge(familiar.getAge());
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
		dto.setAge(family.getAge());
		
		return dto;
		
	}

	@Override
	public void login(AppUserDTO dto) throws ForbiddenException {
		Boolean isSignIn = this.appUserDAO.isSignIn(dto.getUsername());
		if(!isSignIn){
			throw new ForbiddenException("No registrado");
		}
		
	}

	@Override
	public List<FamiliarDTO> getFamiliarByName(String name){
		logger.info("SERVICE: getFamiliarByName method");
		
		List<UserFamily> families = this.userFamilyDAO.getFamiliarByName(name);
		List<FamiliarDTO> dtos = new ArrayList<>();
		
		families.stream().forEach(f -> {
			FamiliarDTO dto = new FamiliarDTO();
			dto.setContacto(f.getContacto());
			dto.setEmail(f.getEmail());
			dto.setFullname(f.getFullname());
			dto.setId(f.getId());
			dto.setImage(f.getImage());
			dto.setAge(f.getAge());
			
			dtos.add(dto);
		});
		
		return dtos;
	}

}
