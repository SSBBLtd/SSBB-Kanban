package com.ssbb.kanban.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.Storable;
import com.ssbb.kanban.data.impl.Role;

public class RoleDAO extends DAOImpl<Storable> {

	/**
	 * Method returns a list of all the roles
	 * 
	 * @return ArrayList of all roles
	 */
	public List<Role> getListOfAllRoles() {
		Query q = em.createNativeQuery("select * from " + "roles", Role.class);
		return q.getResultList();
	}
}
