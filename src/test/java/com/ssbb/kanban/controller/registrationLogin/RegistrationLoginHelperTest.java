package com.ssbb.kanban.controller.registrationLogin;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.ssbb.kanban.dao.impl.UserDAO;
import com.ssbb.kanban.data.impl.User;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationLoginHelperTest {

	@Mock
	UserDAO userdao;

	@Mock
	User user;

	@InjectMocks
	RegistrationLoginHelper helper;

	static final String email = "email";

	static final String password = "password";

	static final String salt = BCrypt.gensalt();

	@Test
	public void testUserExistsFalseWhenUserIsNull() {
		when(userdao.getUserByEmail(email)).thenReturn(null);
		assertFalse(helper.userExists(email));
		verify(userdao).getUserByEmail(email);
	}

	@Test
	public void testUserExistsReturnsTrueWhenUserReturned() {
		when(userdao.getUserByEmail(email)).thenReturn(user);
		assertTrue(helper.userExists(email));
	}

	@Test
	public void testPasswordCorrectReturnsFalseWhenWrongPassword() {
		String hashedPassword = BCrypt.hashpw("test", salt);
		when(user.getPassword()).thenReturn(hashedPassword);
		assertFalse(helper.passwordCorrect(hashedPassword));
	}

	@Test
	public void testPasswordCorrectReturnsTrueWhenCorrect() {
		String hashedPassword = BCrypt.hashpw(password, salt);
		when(user.getPassword()).thenReturn(hashedPassword);
		assertTrue(helper.passwordCorrect(password));
	}

	@Test
	public void testHashPw() {
		helper.hashpw(user);
		verify(user).setPassword(anyString());
	}
}
