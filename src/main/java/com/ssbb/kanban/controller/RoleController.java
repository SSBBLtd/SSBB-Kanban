package com.ssbb.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssbb.kanban.dao.DAOImpl;
import com.ssbb.kanban.data.impl.Role;

public class RoleController {

	@Autowired
	private DAOImpl dao;

	public void getAll() {
		List<Role> all = dao.getAll(Role.class);
		for (Role e : all) {
			System.out.println(e.getId() + " " + e.getType());
		}
	}

}
