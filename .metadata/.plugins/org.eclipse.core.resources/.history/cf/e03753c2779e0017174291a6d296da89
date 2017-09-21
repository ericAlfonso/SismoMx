/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwa.stolencar.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 */
public interface InterfaceDAO<T extends Object> {
	Serializable create(T entity);

	T getById(Serializable id);

	T getByNaturalId(String attribute, Object value);

	T getByNaturalId(String[] attributes, Object[] values);

	List<T> getAll();

	void update(T entity);

	void refresh(T entity);

	void deleteById(Serializable id);

}