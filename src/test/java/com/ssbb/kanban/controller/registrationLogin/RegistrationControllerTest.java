package com.ssbb.kanban.controller.registrationLogin;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

	@Mock
	UserDAO userDAO;

	@Mock
	User user;

	@Mock
	RegistrationLoginHelper helper;

	@InjectMocks
	RegistrationController controller;

	@Test
	public void testLoadRegisterMethod() {

		ModelMap mockedMap = mock(ModelMap.class);

		String result = controller.loadRegister(mockedMap);
		verify(mockedMap).addAttribute(user);
		assertEquals("register", result);
	}

	@Test
	public void testRegisterWhenUserNotExist() {

		HttpSession mockSession = mock(HttpSession.class);
		User mockedUser = mock(User.class);
		when(mockedUser.getEmail()).thenReturn("email");

		String result = controller.register(mockSession, mockedUser);

		verify(mockedUser).setLoggedIn(true);
		verify(helper).hashpw(mockedUser);
		verify(userDAO).add(mockedUser);
		verify(mockSession).setAttribute("user", mockedUser);
		;
		assertEquals("redirect:/landing", result);
	}

	@Test
	public void testRegisterWhenUserExists() {
		/*
		 * when(helper.getAuthenticatedUser(anyString())).thenReturn(true);
		 * 
		 * String result = controller.register(mock(HttpSession.class), user);
		 * assertEquals("redirect:/home", result);
		 */
	}
}
