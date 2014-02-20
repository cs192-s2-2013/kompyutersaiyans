package com.uportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uportal.domain.User;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

 
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ResourceService resourceService;
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {
		String name = principal.getName();
		User user= userService.getUser(name);
		String college= resourceService.getCollege(Integer.parseInt(user.getCollege()));
		String department= resourceService.getDept(Integer.parseInt(user.getDepartment()));
		model.addAttribute("username", name);
		model.addAttribute("user", user);
		model.addAttribute("college", college);
		model.addAttribute("department", department);
		return "hello";
 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model, Principal principal) {
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
				return "home";
		 	}
		return "login";
 
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model, Principal principal) {
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
				return "home";
		 	}
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		model.addAttribute("homePageCounter", resourceService.getHomePageCounter());
		return "home";
 
	}
 
}