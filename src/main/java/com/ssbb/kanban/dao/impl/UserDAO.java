package com.ssbb.kanban.dao.impl;

import javax.persistence.Query;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.User;

public class UserDAO extends DAOImpl<Storable> {

	private final static Class userClass = User.class;

	public User getUserByEmail(String email) {
		Query q = em.createNativeQuery("select * from users where email='"
				+ email + "'", userClass);
		return (User) q.getSingleResult();
	}
}
