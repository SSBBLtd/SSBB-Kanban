package com.ssbb.kanban.dao.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssbb.kanban.data.impl.User;

public class UserDAOTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		UserDAO userDAO = (UserDAO) context.getBean("UserDAO");

		User u = userDAO.getUserByEmail("ilya.skilarov@ssbb.com");
		System.out.println(u.getEmail());
	}

}
