package com.uportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uportal.dao.FeedbackDao;
import com.uportal.domain.Feedback;

public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackDao feedbackdao;
	
	public void addFeed(String username, String feed){
		feedbackdao.addFeed(username, feed);
	}
	
	public List<Feedback> getFeed(){
		return feedbackdao.getFeed();
	}
	
}
