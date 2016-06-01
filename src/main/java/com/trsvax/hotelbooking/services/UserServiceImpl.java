package com.trsvax.hotelbooking.services;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;

import com.trsvax.hotelbooking.entities.Role;
import com.trsvax.hotelbooking.entities.User;

public class UserServiceImpl implements UserService {
	
	private final int hashIterations = 1024;
	
	private final DAO dao;
	
	public UserServiceImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public User getCurrentUser() {
		String principal = (String) SecurityUtils.getSubject().getPrincipal();
		return dao.findByNamedQuery(User.class, "@User.byUsername", "username",principal);
	}

	@Override
	public void newUser(User user) {
		ByteSource byteSource = new SecureRandomNumberGenerator().nextBytes();		
		user.salt = byteSource.toBase64();		
		user.password = new Sha512Hash(user.password, byteSource, hashIterations).toBase64();	
		Set<Role> roles = new HashSet<>();
		roles.add( dao.findByNamedQuery(Role.class, "@Role.byRole", "role","user"));
		user.roles = roles;
		dao.save(user);
		
	}
	
	public HashedCredentialsMatcher getCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher("SHA-512");
		credentialsMatcher.setHashIterations(hashIterations);
		credentialsMatcher.setStoredCredentialsHexEncoded(false);
		return credentialsMatcher;
	}
	
	public SaltedAuthenticationInfo getAuthenticationInfo(User user, String realmName) {
		return new SimpleAuthenticationInfo(
				user.username, user.password.toCharArray(), 
				ByteSource.Util.bytes(Base64.decode(user.salt)), realmName);
	}

	@Override
	public User getUserForPrincipal(String principal) {
		return dao.findByNamedQuery(User.class, "@User.byUsername", "username",principal);
	}

}
