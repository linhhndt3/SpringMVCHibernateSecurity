package edu.java.self.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.java.self.configuration.UserInfo;

@Controller
public class AppController {

	Logger logger = Logger.getLogger(AppController.class);

	@Autowired
	private SessionFactory sessionFactory;

	//	@RequestMapping(value="/")
	//	public ModelAndView sayHello() {
	//		System.out.println("----- hello hanoi dava clazz");
	//		ModelAndView mv = new ModelAndView("index");
	//		mv.addObject("message", "Hello Java Clazz");
	//		return mv;
	//	}
	//	
	//	@RequestMapping(value ="/newuser" , method = RequestMethod.GET)
	//	public String newUser() {
	//		logger.info("--->>> inside controller " + sessionFactory);
	//		
	////		User user = new User();
	////		model.addAttribute("user", user);
	////		model.addAttribute("edit", false);
	//		return "registration";
	//	}

	@RequestMapping("/**")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String handleRequest(HttpServletRequest request, Model model,@AuthenticationPrincipal UserInfo userInfo) {
		//	        Authentication auth = SecurityContextHolder.getContext()
		//	                                                   .getAuthentication();

		System.out.println("--------- already find resource");
		System.out.println("--------- user name: " + userInfo.getUsername() + " and password " + userInfo.getPassword() + " ");
		System.out.println("session: " + userInfo.getSessionId());
		System.out.println(request.getRequestURI());
		//	        System.out.println(auth.getName());
		//	        System.out.println(auth.getAuthorities());
		//	        
		//	        model.addAttribute("uri", request.getRequestURI())
		//	             .addAttribute("user", auth.getName())
		//	             .addAttribute("roles", auth.getAuthorities());
		return "my-page";
	}
}
