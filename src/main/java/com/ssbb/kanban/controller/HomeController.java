package com.ssbb.kanban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.data.impl.Role;

@Controller
public class HomeController {

	@Autowired
	private Role role, role2;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loadHome(HttpServletRequest request, ModelMap map) {
		role2.setType("Admin");
		request.getSession().setAttribute("role", role2);
		// map.put("role", role);
		return "home";
	}

	/*
	 * @RequestMapping(value = "/home") public String load() { return "home"; }
	 */

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login() {

		return "landing";
	}

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public String loadLanding(HttpServletRequest request) {
		request.getSession().setAttribute("role", role2);
		return "landing";
	}

}
