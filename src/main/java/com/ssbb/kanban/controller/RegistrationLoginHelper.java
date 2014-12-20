package com.ssbb.kanban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

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
	protected boolean userExists(String email) {
		if (email != null) {
			user = userDao.getUserByEmail(email);
			if (user != null) {
				return true;
			}
		}
		return false;
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

}
