package edu.java.self.configuration;
//package edu.java.self.configuration;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//	@Override
//	public Authentication authenticate(Authentication authentication)
//			throws AuthenticationException {
//		
//		System.out.println("-------- inside custom authentication");
//		
//		String name = authentication.getName();
//		// You can get the password here
//		String password = authentication.getCredentials().toString();
//		
//		System.out.println("name: " + name + "pass: " +password);
//
//		// Your custom authentication logic here
////		if (name.equals("admin") && password.equals("pwd")) {
////			Authentication auth = new UsernamePasswordAuthenticationToken(name,
////					password);
////
////			return auth;
////		}
//		System.out.println(" --- init ");
//		Authentication auth = new UsernamePasswordAuthenticationToken(name, password);
//		System.out.println(" --- finish ");
////		return new UsernamePasswordAuthenticationToken(name, password);
//		return auth;
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//}