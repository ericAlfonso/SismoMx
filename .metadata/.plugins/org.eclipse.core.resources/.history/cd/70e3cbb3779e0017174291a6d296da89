/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwa.stolencar.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @param <T>
 */
@Repository
public class AbstractDAO<T extends Object> implements InterfaceDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> domainClass;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType domainType = (ParameterizedType) getClass().getGenericSuperclass();

			this.domainClass = (Class<T>) domainType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	@Override
	public Serializable create(T entity) {
		Serializable object = this.getSession().save(entity);
		this.getSession().flush();
		return object;
	}

	@Override
	public T getById(Serializable id) {
		return (T) this.getSession().get(getDomainClass(), id);
	}

	@Override
	public T getByNaturalId(String attribute, Object value) {
		return (T) this.getSession().byNaturalId(getDomainClass()).using(attribute, value).load();
	}

	@Override
	public T getByNaturalId(String[] attributes, Object[] values) {
		if (attributes == null || values == null || attributes.length != values.length)
			throw new IllegalArgumentException("getByNaturalId bad invocation");
		NaturalIdLoadAccess<T> naturalIdLoadAccess = this.getSession().byNaturalId(getDomainClass());
		for (int i = 0; i < attributes.length; i++)
			naturalIdLoadAccess.using(attributes[i], values[i]);
		return (T) naturalIdLoadAccess.load();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return this.getSession().createQuery(" FROM " + getDomainClassName()).list();
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
		this.getSession().flush();
	}

	@Override
	public void refresh(T entity) {
		this.getSession().refresh(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		T entity = getById(id);
		if (entity != null) {
			this.getSession().delete(entity);
			this.getSession().flush();
		}
	}
}
