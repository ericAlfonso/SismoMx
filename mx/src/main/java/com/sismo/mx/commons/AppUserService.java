package com.sismo.mx.commons;

import java.util.List;

import javax.mail.MessagingException;

import com.sismo.mx.commons.dto.AppUserDTO;
import com.sismo.mx.commons.dto.EmailDTO;
import com.sismo.mx.commons.dto.FamiliarDTO;
import com.sismo.mx.commons.exception.ForbiddenException;
import com.sismo.mx.commons.exception.NotFoundException;

public interface AppUserService {

	List<AppUserDTO> getAllAppUsers();
	void sendEmail(EmailDTO dto)  throws MessagingException;
	Integer createFamiliar(FamiliarDTO dto);
	List<FamiliarDTO> getAllFamilies();
	FamiliarDTO getFamiliarDetails(Integer id) throws NotFoundException;
	void login(AppUserDTO dto) throws ForbiddenException;
}