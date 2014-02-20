package com.uportal.controller;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;  

import com.uportal.domain.User;
import com.uportal.domain.ValueTuple;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

@Controller
public class HomePageController {

 @Autowired
 UserService userService;
 @Autowired
 ResourceService resourceService;
 	
 @RequestMapping(value="/home", method = RequestMethod.GET )
	public String homePage(ModelMap model, Principal principal,@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response ) {
	 	if(principal != null){
	 		String name = principal.getName();
			model.addAttribute("username", name);
			model.addAttribute("message", "Spring Security Custom Form example");
	 	}
		 hitCounter++;
		Cookie counter = new Cookie("hitCounter", hitCounter.toString());
		response.addCookie(counter);
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
 
 private void setOptions(ModelMap model){	
	 model.addAttribute("resourceService", resourceService);
 }
 
 @RequestMapping("/hotlines")
 public String hotlinesPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
		 model.addAttribute("username", name);
	 	}
	 List<ValueTuple> hotlineList = new ArrayList<ValueTuple>();
	 hotlineList = resourceService.getHotlines();
	 model.addAttribute("hotlineList", hotlineList);
	 return "hotlines";
 }
 @RequestMapping("/AdminPage")
 public String AdminPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
		model.addAttribute("username", name);
	 	}
	 return "AdminPage";
 }
 @RequestMapping("/description")
 public String descriptionsPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "description";
 }
 
 @RequestMapping("/map")
 public String mapsPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "map";
 }
 
 @RequestMapping("/userList")
 public String userPage(ModelMap model, Principal principal){
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
	 	}
	 return "userList";
 }
 
 @ExceptionHandler(Exception.class)
 public String handleError(HttpServletRequest req, Exception exception) {
   return "redirect:/notfound";
 }
}
