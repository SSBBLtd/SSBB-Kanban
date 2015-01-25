package com.ssbb.kanban.controller.registrationLogin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

@Controller
public class LoginController {

	@Autowired
	private RegistrationLoginHelper loginHelper;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, User user) {
		if (user != null && !user.isLoggedIn()) {

			String email = user.getEmail();
			String password = user.getPassword();
			if (null != email || null != password) {
				if (loginHelper.userExists(email)
						&& loginHelper.passwordCorrect(password)) {

					user = userDAO.getUserByEmail(email);
					user.setLoggedIn(true);
					session.setAttribute("user", user);

					return "redirect:/landing";
				}
			}
			// TO DO set Error logic, user/password invalid
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "landing", method = RequestMethod.GET)
	public String loadLanding(HttpSession session) {
		if (null != session.getAttribute("user")) {
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
