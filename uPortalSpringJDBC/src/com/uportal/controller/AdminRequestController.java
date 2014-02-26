package com.uportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uportal.domain.User;
import com.uportal.services.AdminRequestService;
import com.uportal.services.UserService;

@Controller
public class AdminRequestController {

	@Autowired
	AdminRequestService adminRequestService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/request_portal")
	public String requestPortal(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),4) == 0)
			model.addAttribute("request_success", "true");
		else
			model.addAttribute("request_failure", "true");
		return "request";
	}
	
	@RequestMapping("/request_maps")
	public String requestMaps(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),5) == 0)
			model.addAttribute("request_success", "true");
		else
			model.addAttribute("request_failure", "true");
		return "request";
	}
	
	@RequestMapping("/request_buddy")
	public String requestBuddy(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),6) == 0)
			model.addAttribute("request_success", "true");
		else
			model.addAttribute("request_failure", "true");
		return "request";
	}
	
	@RequestMapping("/request_class")
	public String requestClass(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),7) == 0)
			model.addAttribute("request_success", "true");
		else
			model.addAttribute("request_failure", "true");
		return "request";
	}
	
	@RequestMapping("/request_gym")
	public String requestGym(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		User user= userService.getUser(name);
		if(adminRequestService.addAdminRequest(user.getUserId(),8) == 0)
			model.addAttribute("request_success", "true");
		else
			model.addAttribute("request_failure", "true");
		return "request";
	}
	
}
