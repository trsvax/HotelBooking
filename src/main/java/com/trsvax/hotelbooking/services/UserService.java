package com.trsvax.hotelbooking.services;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import com.trsvax.hotelbooking.entities.User;

public interface UserService {

	public User getCurrentUser();
	
	public User getUserForPrincipal(String principal);
	
	public void newUser(User user);
	
	public HashedCredentialsMatcher getCredentialsMatcher();
	
	public SaltedAuthenticationInfo getAuthenticationInfo(User user, String realmName);
}
