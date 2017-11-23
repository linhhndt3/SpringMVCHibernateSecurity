package edu.java.self.configuration;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {
	private static final long serialVersionUID = 3399864372644089845L;
//	private User user;
	private boolean authenticated;
//	private Info info;
	private String ipAddress;
	private String token;
	private UserInfo userInfo;
//	private AuthType authType;

//	public UserAuthentication(User user) {
//		this.user = user;
//		this.info = new Info();
//	}
	
	@Override
	public String getName() {
		return userInfo.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userInfo.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return userInfo.getPassword();
	}

	@Override
	public UserInfo getDetails() {
		return userInfo;
	}

	@Override
	public Object getPrincipal() {
		return userInfo.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException { // NOSONAR
		authenticated = isAuthenticated;
	}
	
	public UserInfo getUser() {
		return userInfo;
	}

	public void setUser(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
