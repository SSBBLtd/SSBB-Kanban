package com.ssbb.kanban.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleControllerTest {

	private RoleController roleController;

	@Before
	public void setup() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		roleController = (RoleController) context.getBean("roleController");

	}

	@Test
	public void test() {

		roleController.getAll();

	}

}
