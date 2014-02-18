package com.uportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uportal.domain.User;
import com.uportal.services.UserService;

 
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {
		String name = principal.getName();
		User user= userService.getUser(name);
		model.addAttribute("username", name);
		model.addAttribute("message", "Welcome");
		model.addAttribute("user", user);
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
 
		return "home";
 
	}
 
}