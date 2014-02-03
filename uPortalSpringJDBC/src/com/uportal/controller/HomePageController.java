package com.uportal.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;  
import com.uportal.services.UserService;

@Controller
public class HomePageController {

 @Autowired
 UserService userService;

 	
 @RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage(ModelMap model, Principal principal ) {
	 	if(principal != null){
	 		String name = principal.getName();
			model.addAttribute("username", name);
			model.addAttribute("message", "Spring Security Custom Form example");
	 	}
		
		return "home";

	}
 
 @RequestMapping(value="/private", method = RequestMethod.GET)
	public String privatePage(ModelMap model, Principal principal ) {

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "This is a private feature");
		return "private";

	}
 
 @RequestMapping("/public")
 public String publicPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "public";
 }
 
 @RequestMapping("/hotlines")
 public String hotlinesPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "hotlines";
 }
 
 @ExceptionHandler(Exception.class)
 public String handleError(HttpServletRequest req, Exception exception) {
   return "redirect:/notfound";
 }
}
