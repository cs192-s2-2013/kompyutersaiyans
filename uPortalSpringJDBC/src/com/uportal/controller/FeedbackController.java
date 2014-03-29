package com.uportal.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller
public class FeedbackController {

	@RequestMapping("/feedback")
	 public String feedbackPage(ModelMap model, Principal principal){
		 if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		 System.out.println("HALLELUHAH");
		 return "feedback";
	 }
	
	@RequestMapping("/send_feedback")
	public String sendFeedback(ModelMap model, Principal principal, HttpServletRequest response){
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		System.out.println("AJEJEJEJEHUHUHUH");
		String feedback = response.getParameter("feedback");
		String name = response.getParameter("name");
		if(feedback.trim() != null)
		{
			System.out.println("YEYY MERONG FEEDBACK");
			System.out.println(name.trim());
			System.out.println(feedback.trim());
		}
		else
			System.out.println("DED");
		return "redirect:/feedback";
	}
}