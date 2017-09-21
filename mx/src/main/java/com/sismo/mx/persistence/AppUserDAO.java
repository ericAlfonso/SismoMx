package com.sismo.mx.persistence;

import com.sismo.mx.persistence.entities.AppUser;

public interface AppUserDAO extends InterfaceDAO<AppUser>{

	Boolean isSignIn(String username);
}
