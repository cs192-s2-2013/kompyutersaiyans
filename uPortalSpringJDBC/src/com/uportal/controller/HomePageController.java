package com.uportal.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;  
import org.springframework.validation.BindingResult; 

import com.uportal.domain.User;
import com.uportal.services.UserService;
import com.uportal.validator.FormValidation;

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
		 if (unique == 1){
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
 
 @ExceptionHandler(Exception.class)
 public String handleError(HttpServletRequest req, Exception exception) {
   return "redirect:/home";
 }
}
