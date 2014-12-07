package com.ssbb.kanban.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControllerTest {

	UserController userController;

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		userController = (UserController) context.getBean("userController");
		userController.getByEmail();
	}

}
