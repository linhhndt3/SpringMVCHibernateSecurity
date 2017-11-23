package edu.java.self.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
	
	@Autowired
	private TokenAuthenticationService tokenAuthenticationService;

	public LoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);

//		tokenAuthenticationService = (TokenAuthenticationService) ApplicationContextProvider.getApplicationContext()
//				.getBean("tokenAuthenticationServiceImpl");
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException  { // NOSONAR
		System.out.println("login filter");
		UserAuthentication auth = (UserAuthentication) new TokenAuthenticationServiceImpl().getAuthenticationForLogin(request, response);
		if (!auth.isAuthenticated()) {
			System.out.println("exception");
			throw new IOException();
		}

		return auth;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			javax.servlet.FilterChain chain, Authentication authResult) throws IOException, ServletException {
			System.out.println("successfull Authntication");
			// Add the authentication to the Security context
			SecurityContextHolder.getContext().setAuthentication(authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		System.out.println("xxxxx ------ unsuccessfull Authntication");
//		UserAuthenticationException authException = (UserAuthenticationException) failed;
//		Info info = authException.getAuthentication().getInfo();
//
//		response.setHeader("X-AUTH-ERR-DESC", info.getCode() + "-" + info.getDesc());
//
//		ObjectMapper mapper = new ObjectMapper();
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(mapper.writeValueAsString(authException.getAuthentication().getInfo()));
//
//		loginFilterLogger.info("Authentication FAIL. " + Util.getInputLogsSimple("ip, username, reason",
//				authException.getAuthentication().getIpAddress(), request.getHeader("username"), info));
	}

}
