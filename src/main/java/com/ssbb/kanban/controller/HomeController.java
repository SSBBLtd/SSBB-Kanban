package com.ssbb.kanban.controller;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loadHome(HttpServletRequest request, ModelMap map) {
		request.getSession().setAttribute("user", user);
		map.addAttribute("user", user);
		return "home";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(User user) {
		return "landing";
	}

	public void setUser(User user) {
		this.user = user;
	}

}
