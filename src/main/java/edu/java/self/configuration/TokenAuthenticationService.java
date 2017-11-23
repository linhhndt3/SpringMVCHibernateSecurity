package edu.java.self.configuration;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

public interface TokenAuthenticationService {
	
	public Authentication getAuthenticationForLogin(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
//	public UserToken addAuthentication(HttpServletResponse response, UserAuthentication authResult);
	

}
