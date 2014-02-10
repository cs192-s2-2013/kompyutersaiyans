package com.uportal.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;  
import org.springframework.validation.BindingResult; 

import com.uportal.domain.User;
import com.uportal.services.UserService;
import com.uportal.validator.FormValidation;

@Controller
public class RegistrationController {

 @Autowired
 UserService userService;

 
 @RequestMapping("/register")
 public ModelAndView registerUser(@ModelAttribute User user, ModelMap model, Principal principal) {
	 if(principal != null){
		 String name = principal.getName();
			model.addAttribute("username", name);
			return new ModelAndView("home");
	 	}
	 Map<String, List<User>> map = new HashMap<String, List<User>>();
	 return new ModelAndView("register", "map", map);
 }

 @RequestMapping("/submit")  
 public String saveForm(User user, BindingResult result, ModelMap model, Principal principal) {  
	  FormValidation formValidation = new FormValidation();  
	  
	  formValidation.validate(user, result);  
	  
	  if (result.hasErrors()) {    
	   return "register";  
	  }else{
		  user = (User) result.getModel().get("user");  
		 int unique =  userService.insertData(user);
		 if(unique == 3){
			 model.addAttribute("msg_failed", "3");
			 return "register";
		 }
		 else if (unique == 1){
			 model.addAttribute("msg_failed", "1");
			 return "register";
		 }else if (unique == 2){
			 model.addAttribute("msg_failed", "2");
			 return "register";
		 }else{
		  System.out.println(user.getUserId()); 
			 model.addAttribute("msg_success", "true");
			 return "home";
		 }
	  }
	   
 }  
}
