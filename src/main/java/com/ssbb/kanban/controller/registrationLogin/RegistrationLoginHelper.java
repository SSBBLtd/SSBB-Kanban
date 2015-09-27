package com.ssbb.kanban.controller.registrationLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;
import com.ssbb.kanban.utils.StringHelper;

public class RegistrationLoginHelper {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private User user;

	/**
	 * Method to check if a user with a given email address exists in the
	 * database
	 * 
	 * @author - Raymond Tong
	 * @param email
	 *            - Email address which user is using for login/registration
	 * @return
	 */
	protected User getAuthenticatedUser(User user) {
		if (!StringHelper.isNullOrEmpty(user.getEmail())) {
			this.user = userDao.getUserByEmail(user.getEmail());
			if (null != this.user && passwordCorrect(user.getPassword())) {
				return this.user;
			}
		}
		return null;
	}

	/**
	 * Method to check if the password entered during login matches the one
	 * stored in the database
	 * 
	 * @param password
	 * @return
	 */
	protected boolean passwordCorrect(String password) {
		return BCrypt.checkpw(password, user.getPassword());
	}

	protected void hashpw(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
	}
}
