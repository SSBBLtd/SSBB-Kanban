package com.ssbb.kanban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

public class UserController {

	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userDAO;

	@Autowired
	private User user;

	public User getByEmail() {
		user = userDAO.getUserByEmail("ilya.skliarov@ssbb.com");
		System.out.println(user.getEmail());
		return user;
	}
}
