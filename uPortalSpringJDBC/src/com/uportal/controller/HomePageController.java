package com.uportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;  
import org.springframework.ui.ModelMap;  
import org.springframework.validation.BindingResult; 

import com.uportal.domain.User;
import com.uportal.services.UserService;
import com.uportal.validator.FormValidation;

@Controller
public class HomePageController {

	boolean initDB = false;
	
	@Autowired
	UserService userService;

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		return new ModelAndView("register", "map", map);
	}

	@RequestMapping("/insert")
	public String insertData(@ModelAttribute User user) {
		if (!initDB)
		{
			userService.initDB();
			initDB = true;
		}
		if (user != null)
			userService.insertData(user);
		return "redirect:/getList";
	}


 @RequestMapping("/submit")  
 public String saveForm(User user, BindingResult result, ModelMap model) {  
  FormValidation formValidation = new FormValidation();  
  
  formValidation.validate(user, result);  
  
  if (result.hasErrors()) {    
   return "register";  
  }  
  
  user = (User) result.getModel().get("user");  
  userService.insertData(user);
  System.out.println(user.getUserId());  
  return "redirect:/getList";  
 }  
 
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
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String userid) {
		System.out.println("userid = " + userid);
		userService.deleteData(userid);
		return "redirect:/getList";
	}
}
