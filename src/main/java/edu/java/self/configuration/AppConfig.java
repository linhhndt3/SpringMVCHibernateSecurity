package edu.java.self.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebMvc
@ComponentScan(basePackages = {"edu.java.self.controller", "edu.java.self.configuration","edu.java.self.service","edu.java.self.dao"})
public class AppConfig extends WebSecurityConfigurerAdapter  {
	//	@Override
	//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	//		System.out.println("enable config");
	//		configurer.enable();
	//	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
	}
//
	@Override
	public void configure(AuthenticationManagerBuilder builder)
			throws Exception {
		builder.userDetailsService(new SSUserDetailsService());
		//	        builder.authenticationProvider(new CustomAuthenticationProvider());
	}
	
	// try to command this bean, this will lead to invoke target controller two time ???
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//	@Bean
	//	public InternalResourceViewResolver viewResolver() {
	//		System.out.println("--- create bean");
	//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	////		resolver.setOrder(1);
	//		resolver.setPrefix("/jsp/");
	//		resolver.setSuffix(".jsp");
	//		return resolver;
	//	}
	
	//	
	//	@Bean
	//	public TilesConfigurer tilesConfigure(){
	//		TilesConfigurer configure = new TilesConfigurer();
	//		configure.setDefinitions("/tiles/definitions.xml");
	//		return configure;
	//	}
	//	
}
