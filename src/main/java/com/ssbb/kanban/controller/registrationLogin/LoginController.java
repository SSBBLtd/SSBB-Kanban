package com.ssbb.kanban.controller.registrationLogin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssbb.kanban.Constants;
import com.ssbb.kanban.dao.impl.ProjectDAO;
import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.Project;
import com.ssbb.kanban.data.impl.User;
import com.ssbb.kanban.utils.StringHelper;

@Controller
public class LoginController {

	@Autowired
	private RegistrationLoginHelper loginHelper;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Project project;

	@Autowired
	private ProjectDAO projectDAO;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap map, HttpSession session, User user) {
		if (user != null && !user.isLoggedIn()) {

			String email = user.getEmail();
			String password = user.getPassword();
			if (!StringHelper.isNullOrEmpty(email)
					|| !StringHelper.isNullOrEmpty(password)) {
				if (loginHelper.userExists(email)
						&& loginHelper.passwordCorrect(password)) {

					user = userDAO.getUserByEmail(email);
					user.setLoggedIn(true);
					session.setAttribute(Constants.USER, user);

					return loadLanding(map, session, user);
				}
			}
			// TO DO set Error logic, user/password invalid
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "landing", method = RequestMethod.GET)
	public String loadLanding(ModelMap map, HttpSession session, User user) {
		if (null != session.getAttribute(Constants.USER)) {

			// This is for being able to create a new project
			map.addAttribute(Constants.PROJECT, project);
			map.addAttribute(Constants.USER, user);
			if (null == session.getAttribute(Constants.PROJECT_LIST)) {
				session.setAttribute(Constants.PROJECT_LIST,
						projectDAO.getProjectsByUser(user));
			}
			return "landing";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(ModelMap map, HttpSession session) {
		map.remove(Constants.USER);
		session.invalidate();
		return "redirect:/home";
	}
}
