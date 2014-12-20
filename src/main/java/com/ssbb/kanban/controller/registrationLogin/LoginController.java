package com.ssbb.kanban.controller.registrationLogin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.data.impl.User;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null && user.isLoggedIn()) {
			return "redirect:/landing";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "landing", method = RequestMethod.GET)
	public String loadLanding(HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "landing";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(ModelMap map, HttpSession session) {
		map.remove("user");
		session.invalidate();
		return "redirect:/home";
	}
}
