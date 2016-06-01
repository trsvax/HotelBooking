package com.trsvax.hotelbooking.pages.user;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.services.UserService;

public class UserSignUp {
	
	@Property
	User user;
	
	@Inject
	UserService userService;
	
	@CommitAfter
	void onSuccess() {		
		userService.newUser(user);
	}

}
