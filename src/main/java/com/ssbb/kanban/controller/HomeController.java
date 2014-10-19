package com.ssbb.kanban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.data.impl.Role;

@Controller
public class HomeController {

	@Autowired
	private Role role;

	@RequestMapping(value = "/home")
	public String loadHome(ModelMap map) {
		map.put("role", role);
		return "/home";
	}

	/*
	 * @RequestMapping(value = "/home") public String load() { return "home"; }
	 */

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login() {

		return "landing";
	}

	@RequestMapping(value = "/trial2")
	public String trailPage() {
		return "trial2";
	}

}
