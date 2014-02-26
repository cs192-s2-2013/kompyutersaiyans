package com.uportal.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller

public class WelcomeController {
	
	@RequestMapping("/request")
	public String requestAdmin(ModelMap model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		return "request";
	}
	
	
}
