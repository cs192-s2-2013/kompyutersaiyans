package com.uportal.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.ModelMap;

import com.uportal.domain.Feedback;
import com.uportal.services.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedService;
	
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
			feedService.addFeed(name.trim(), feedback);
		}
		else
			System.out.println("DED");
		return "redirect:/feedback";
	}
	
	@RequestMapping("/feeds")
	public String getFeedback(ModelMap model, Principal principal){
		if(principal != null){
			 String name = principal.getName();
				model.addAttribute("username", name);
		 	}
		
		List<Feedback> feeds = feedService.getFeed();
		model.addAttribute("feeds", feeds);
		return "feeds";
	}
	
}