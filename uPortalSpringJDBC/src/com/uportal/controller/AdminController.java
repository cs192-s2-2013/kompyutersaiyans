package com.uportal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uportal.domain.AdminRequest;
import com.uportal.domain.User;
import com.uportal.domain.ValueTuple;
import com.uportal.services.AdminRequestService;
import com.uportal.services.ResourceService;
import com.uportal.services.UserService;

@Controller

public class AdminController {
	@Autowired
	 UserService userService;
	
	@Autowired
	 ResourceService resourceService;
	
	@Autowired
	AdminRequestService adminRequestService;
	
	@RequestMapping("/getList")
	 public ModelAndView getUserLIst() {
	  List<User> userList = userService.getUserList();
	  return new ModelAndView("userList", "userList", userList);
	 }

	 @RequestMapping("/edit")
	 public ModelAndView editUser(@RequestParam String userid,
	   @ModelAttribute User user) {

	  user = userService.getUser(userid);

	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("user", user);

	  return new ModelAndView("edit", "map", map);

	 }

	 @RequestMapping("/update")
	 public String updateUser(@ModelAttribute User user) {
	  userService.updateData(user);
	  return "redirect:/update";

	 }

	 @RequestMapping("/delete")
	 public String deleteUser(@RequestParam String userid) {
	  System.out.println("userid = " + userid);
	  userService.deleteData(userid);
	  return "redirect:/getList";
	 }
	 
	 @RequestMapping("/requestList")
	 public String request(ModelMap model, Principal principal) {
		 model.addAttribute("request", "true");
		 if(principal != null){
			 String name = principal.getName();
			 model.addAttribute("username", name);
		 }
		 List<ValueTuple> hotlineList = new ArrayList<ValueTuple>();
		 hotlineList = resourceService.getHotlines();
		 model.addAttribute("hotlineList", hotlineList);
		 model.addAttribute("homePageCounter", resourceService.getHomePageCounter());
		 model.addAttribute("numberOfAdminRequests", adminRequestService.getNumberOfAdminRequests());
		 List<AdminRequest> adminRequestList = new ArrayList<AdminRequest>();
		 adminRequestList = adminRequestService.getAdminRequestList();
		 model.addAttribute("adminRequestList", adminRequestList);
		 List<AdminRequest> adminList = new ArrayList<AdminRequest>();
		 adminList = adminRequestService.getAdminList();
		 model.addAttribute("adminList", adminList);
		 return "AdminPage";
	 }
	 
	 @RequestMapping("/decline_admin")
	 public String declineAdmin(@RequestParam String userid, @RequestParam String typeid) {
		 System.out.println(userid + " " + typeid);
		 adminRequestService.deleteAdminRequest(userid,typeid);
		 return "redirect:/requestList";
	 }
	 
	 @RequestMapping("/approve_admin")
	 public String approveAdmin(@RequestParam String userid, @RequestParam String typeid) {
		 adminRequestService.addAdmin(userid,typeid);
		 adminRequestService.deleteAdminRequest(userid, typeid);
		 return "redirect:/requestList";
	 }
	 
	 @RequestMapping("/delete_admin")
	 public String deleteAdmin(@RequestParam String userid, @RequestParam String typeid, ModelMap model) {
		 model.addAttribute("seeAdminList", "true");
		 return "AdminPage";
	 }
}
