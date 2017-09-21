package com.sismo.mx.rest.parser;

import java.util.List;

import com.sismo.mx.commons.dto.AppUserDTO;
import com.sismo.mx.commons.dto.EmailDTO;
import com.sismo.mx.commons.dto.FamiliarDTO;
import com.sismo.mx.rest.vo.AppUserVO;
import com.sismo.mx.rest.vo.EmailVO;
import com.sismo.mx.rest.vo.FamiliarVO;

public interface AppUserParser {

	List<AppUserVO> parseToUserVOList(List<AppUserDTO> appUserDTOs);
	AppUserVO parseToUserVO(AppUserDTO appUserDTO);
	EmailDTO parseToEmailDTO(EmailVO emailVO);
	List<FamiliarVO> parseToFamiliarVOList(List<FamiliarDTO> dtos);
	FamiliarVO parseToFamiliarVO(FamiliarDTO dto);
	FamiliarDTO parseToFamiliarDTO(FamiliarVO familiarVO);
	AppUserDTO parseToUserDTO(AppUserVO appUserVO);
}
