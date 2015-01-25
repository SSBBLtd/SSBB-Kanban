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
public class RegistrationController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired
	private RegistrationLoginHelper helper;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String loadRegister(ModelMap map) {
		map.addAttribute(user);
		return "register";
	}

	/**Method to register a new user. Registration will fail if the email address has already been used
	 * 
	 * @author Ilya Skliarov, Raymond Tong
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register/register", method = RequestMethod.POST)
	public String register(HttpSession session, User user) {
		String email = user.getEmail();
		if (!helper.userExists(email)) {
			user.setLoggedIn(true);
			helper.hashpw(user);
			userDAO.add(user);
			session.setAttribute("user", user);
			return "redirect:/landing";
		}
		return "redirect:/home";
	}
	
}
