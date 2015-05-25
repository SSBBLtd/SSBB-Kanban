package com.ssbb.kanban.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.User;

public class UserDAO extends DAOImpl<Storable> {

	private final static Class<User> userClass = User.class;

	public User getUserByEmail(String email) {
		Query q = em.createNativeQuery(
				"select * from users where email = :email", userClass);
		q.setParameter("email", email);
		List<User> resultList = q.getResultList();

		if (resultList.isEmpty()) {
			return null;
		}

		return (User) resultList.get(0);
	}

}
