package com.uportal.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/counter")
	public String updateCounter(
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response, ModelMap model, Principal principal ) {
		
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		
		Cookie counter = new Cookie("hitCounter", hitCounter.toString());
		response.addCookie(counter);
		return "counter";
	}
	
	@RequestMapping("/reset")
	public String checkCounter(
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response, ModelMap model, Principal principal) {
		hitCounter -= hitCounter;
		Cookie counter = new Cookie("hitCounter", hitCounter.toString());
		response.addCookie(counter);
		if(principal != null)
		{
			String name = principal.getName();
			model.addAttribute("username", name);
		}
		model.addAttribute("reset_success", "true");
		return "AdminPage";
	}

}
