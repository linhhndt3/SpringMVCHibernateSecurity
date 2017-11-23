package edu.java.self.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.java.self.configuration.UserInfo;
import edu.java.self.model.Employee;
import edu.java.self.service.EmployeeService;

@Controller
public class AppController {

	Logger logger = Logger.getLogger(AppController.class);

		@RequestMapping(value="/hello")
		public @ResponseBody String sayHello() {
			System.out.println("----- hello hanoi dava clazz");
			logger.info("----- log");
//			ModelAndView mv = new ModelAndView("index");
//			mv.addObject("message", "Hello Java Clazz");
			return "Hello";
		}
	@Autowired
	private EmployeeService employeeService;
	
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

	@RequestMapping("/")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String handleRequest(HttpServletRequest request, Model model) {
		//	        Authentication auth = SecurityContextHolder.getContext()
		//	                                                   .getAuthentication();

		System.out.println("--------- already find resource 24-10");
//		System.out.println("--------- user name: " + userInfo.getUsername() + " and password " + userInfo.getPassword() + " ");
//		System.out.println("session: " + userInfo.getSessionId());
		System.out.println(request.getRequestURI());
		//	        System.out.println(auth.getName());
		//	        System.out.println(auth.getAuthorities());
		//	        
		//	        model.addAttribute("uri", request.getRequestURI())
		//	             .addAttribute("user", auth.getName())
		//	             .addAttribute("roles", auth.getAuthorities());
		
//		Employee employee = new Employee();
//		employee.setName("name1336");
//		employee.setSalary(new BigDecimal("100000"));
//		employee.setSsn("abc1236");
//		
//		employeeService.saveEmployee(employee);
		return "my-page";
	}
	
	@RequestMapping("/them")
//	@PreAuthorize("hasRole('ROLE_USER')")
	public String them(HttpServletRequest request, Model model,@AuthenticationPrincipal UserInfo userInfo) {
		//	        Authentication auth = SecurityContextHolder.getContext()
		//	                                                   .getAuthentication();

//		System.out.println("--------- already find resource");
//		System.out.println("--------- user name: " + userInfo.getUsername() + " and password " + userInfo.getPassword() + " ");
//		System.out.println("session: " + userInfo.getSessionId());
//		System.out.println(request.getRequestURI());
		//	        System.out.println(auth.getName());
		//	        System.out.println(auth.getAuthorities());
		//	        
		//	        model.addAttribute("uri", request.getRequestURI())
		//	             .addAttribute("user", auth.getName())
		//	             .addAttribute("roles", auth.getAuthorities());
		
		Employee employee = new Employee();
		employee.setName("name13");
		employee.setSalary(new BigDecimal("100000"));
		employee.setSsn("abc1");
		
		employeeService.saveEmployee(employee);
		return "my-page";
	}
}
