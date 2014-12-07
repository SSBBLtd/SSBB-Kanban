package com.ssbb.kanban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

@Controller
public class RegistrationController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(User user) {
		user.setEmail(email);

		return null;
	}

}
