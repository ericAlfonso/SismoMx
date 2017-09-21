package com.sismo.mx.persistence;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sismo.mx.persistence.entities.AppUser;

@Repository
public class AppUserDAOImpl extends AbstractDAO<AppUser> implements AppUserDAO{

	@Override
	public Boolean isSignIn(String username) {
		boolean exists = ((Number) getSession().createCriteria(AppUser.class, "user")
				.add(Restrictions.eq("user.username", username))
				.setProjection(Projections.rowCount())
				.uniqueResult()).intValue() != 0;
		
		return exists;
	}

}
