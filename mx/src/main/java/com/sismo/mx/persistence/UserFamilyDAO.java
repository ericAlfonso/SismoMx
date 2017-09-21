package com.sismo.mx.persistence;

import java.util.List;

import com.sismo.mx.persistence.entities.UserFamily;

public interface UserFamilyDAO extends InterfaceDAO<UserFamily>{

	List<UserFamily> getFamiliarByName(String name);
}
