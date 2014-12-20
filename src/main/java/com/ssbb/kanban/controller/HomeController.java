package com.ssbb.kanban.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String loadHome(ModelMap map, HttpSession session) {
		User user = (User) map.get("user");
		if (user != null && !user.isLoggedIn()) {
			map.remove("user");
			session.removeAttribute("user");
		}
		return "home";
	}
}
