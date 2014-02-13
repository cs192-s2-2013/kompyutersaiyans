package com.uportal.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uportal.domain.User;
import com.uportal.services.UserService;

@Controller

public class AdminController {
	@Autowired
	 UserService userService;
	
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
}
