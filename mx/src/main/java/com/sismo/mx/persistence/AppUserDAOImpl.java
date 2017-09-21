package com.sismo.mx.persistence;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sismo.mx.persistence.entities.AppUser;

@Repository
public class AppUserDAOImpl extends AbstractDAO<AppUser> implements AppUserDAO{

	@Override
	public Boolean isSignIn(String username) {
		return getSession().createCriteria(AppUser.class, "user")
				.add(Restrictions.eq("user.username", username))
				.uniqueResult() != null;
	}

}