package com.trsvax.hotelbooking.services.hibernate;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.trsvax.hotelbooking.entities.User;
import com.trsvax.hotelbooking.services.UserService;

public class HibernateRealm extends AuthorizingRealm {
	
	private final UserService userService;
	
	public HibernateRealm(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(@NotNull PrincipalCollection principals) {
		
		String principal = (String) getAvailablePrincipal(principals);
		
		User user = userService.getUserForPrincipal(principal);
		Set<String> roleNames = user.roles.stream().map(a -> a.role).collect(Collectors.toSet());
		Set<String> permissions = user.permissions.stream().map(a -> a.permission).collect(Collectors.toSet());

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String principal = ((UsernamePasswordToken) token).getUsername();
				            
		User user = userService.getUserForPrincipal(principal);
				
		return userService.getAuthenticationInfo(user, getName());
	}

}
