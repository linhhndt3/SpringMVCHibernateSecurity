package edu.java.self.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SSUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("------ load user detail: "+ username);

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("admin");
		userInfo.setPassword("123456");
		userInfo.setSessionId("asdfghjkl");
		userInfo.setAuthorities(getAuthorities());

		return userInfo;
		//		return new org.springframework.security.core.userdetails.User("admin", "123456", getAuthorities());
	}

	private Set<GrantedAuthority> getAuthorities(){

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("ROLE_ADMIN"); // check whether ADMIN or ROLE_ADMIN
		GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(grantedAuthority1);
		authorities.add(grantedAuthority2);

		return authorities;
	}
}
