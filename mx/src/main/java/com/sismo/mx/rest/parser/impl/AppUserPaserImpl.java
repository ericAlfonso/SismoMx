package com.sismo.mx.rest.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sismo.mx.commons.dto.AppUserDTO;
import com.sismo.mx.commons.dto.EmailDTO;
import com.sismo.mx.commons.dto.FamiliarDTO;
import com.sismo.mx.rest.parser.AppUserParser;
import com.sismo.mx.rest.vo.AppUserVO;
import com.sismo.mx.rest.vo.EmailVO;
import com.sismo.mx.rest.vo.FamiliarVO;

@Component
public class AppUserPaserImpl implements AppUserParser{

	@Override
	public List<AppUserVO> parseToUserVOList(List<AppUserDTO> appUserDTOs) {
		List<AppUserVO> vos = new ArrayList<>();
		if(appUserDTOs == null)
			return vos;
		
		for(AppUserDTO appUserDTO: appUserDTOs) {
			vos.add(this.parseToUserVO(appUserDTO));
		}
		
		return vos;
	}

	@Override
	public AppUserVO parseToUserVO(AppUserDTO appUserDTO) {
		if(appUserDTO == null)
			return null;
		
		AppUserVO vo = new AppUserVO();
		vo.setEmail(appUserDTO.getEmail());
		vo.setUsername(appUserDTO.getUsername());
		vo.setPassword(appUserDTO.getPassword());
		vo.setIsAdmin(appUserDTO.getIsAdmin());
		
		return vo;
	}

	@Override
	public EmailDTO parseToEmailDTO(EmailVO emailVO) {
		if(emailVO == null)
			return null;
		
		EmailDTO dto = new EmailDTO();
		dto.setTo(emailVO.getTo());
		dto.setSubject(emailVO.getSubject());
		dto.setBody(emailVO.getBody());
		
		return dto;
	}

	@Override
	public FamiliarDTO parseToFamiliarDTO(FamiliarVO familiarVO) {
		if(familiarVO == null)
			return null;
		
		FamiliarDTO dto = new FamiliarDTO();
		dto.setEmail(familiarVO.getEmail());
		dto.setFullname(familiarVO.getFullname());
		dto.setContacto(familiarVO.getContacto());
		dto.setImage(familiarVO.getImage());
		dto.setAge(familiarVO.getAge());
		
		return dto;
	}

	@Override
	public List<FamiliarVO> parseToFamiliarVOList(List<FamiliarDTO> dtos) {
		List<FamiliarVO> familiarVOs = new ArrayList<>();
		if(dtos == null)
			return null;
		
		for(FamiliarDTO dto : dtos) {
			familiarVOs.add(this.parseToFamiliarVO(dto));
		}
		
		return familiarVOs;
	}

	@Override
	public FamiliarVO parseToFamiliarVO(FamiliarDTO dto) {
		if(dto == null)
			return null;
		
		FamiliarVO familiarVO = new FamiliarVO();
		familiarVO.setContacto(dto.getContacto());
		familiarVO.setEmail(dto.getEmail());
		familiarVO.setFullname(dto.getFullname());
		familiarVO.setImage(dto.getImage());
		familiarVO.setId(dto.getId());
		familiarVO.setAge(dto.getAge());
		
		return familiarVO;
	}

	@Override
	public AppUserDTO parseToUserDTO(AppUserVO appUserVO) {
		if(appUserVO == null)
			return null;
		
		AppUserDTO dto = new AppUserDTO();
		dto.setEmail(appUserVO.getEmail());
		dto.setUsername(appUserVO.getUsername());
		dto.setPassword(appUserVO.getPassword());
		dto.setIsAdmin(appUserVO.getIsAdmin());
		
		return dto;
	}

}
