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
public class RegistrationController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String loadRegister(HttpServletRequest request, ModelMap map) {
		request.getSession().setAttribute("user", user);
		map.addAttribute("user",
				(User) request.getSession().getAttribute("user"));
		return "register";
	}

	@RequestMapping(value = "register/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, User user) {
		userDAO.add(user);
		return "redirect:/login";
	}

}
