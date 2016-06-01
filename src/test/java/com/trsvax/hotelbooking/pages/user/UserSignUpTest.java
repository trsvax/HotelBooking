package com.trsvax.hotelbooking.pages.user;

import static org.junit.Assert.*;

import org.junit.Test;

import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.services.DAO;
import com.trsvax.hotelbooking.services.DAOsImple;
import com.trsvax.hotelbooking.services.UserServiceImpl;

public class UserSignUpTest {

	@Test
	public void onSuccess() {
		UserSignUp page = new UserSignUp();
		DAO dao = new DAOsImple();
		page.userService = new UserServiceImpl(dao);
		page.user = new User();
		page.user.password = "password";
		page.onSuccess();
		assertTrue(dao.findAll(User.class) != null );
		
	}

}
