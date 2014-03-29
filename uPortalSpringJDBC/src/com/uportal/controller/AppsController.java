package com.uportal.controller;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uportal.domain.User;
import com.uportal.services.AdminRequestService;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

@Controller
public class AppsController {
	 @Autowired
	 UserService userService;
	 @Autowired
	 ResourceService resourceService;
	 @Autowired
	 AdminRequestService adminRequestService;
	 @Autowired
	 DataSource dataSource;
	 
	 
	 /*
	 public String homePage(ModelMap model, Principal principal,@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
	 HttpServletResponse response ) { */
	 @RequestMapping(value="/goup", method = RequestMethod.GET )
	   public String maps(ModelMap model, Principal principal) {
			 if(principal == null){
				 return "redirect:/welcome";
			 }
		 	return "redirect:http://localhost:9999/UPMap/home";
	 	}
	 
	 @RequestMapping(value="/braingym", method = RequestMethod.GET )
	   public String brain(ModelMap model, Principal principal) {
		 if(principal == null){
			 return "redirect:/welcome";
		 }
		 	return "redirect:http://localhost:9999/braingym/";
	 	}

}
