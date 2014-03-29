package com.uportal.services;

import java.util.List;

import com.uportal.domain.Feedback;

public interface FeedbackService {
	public void addFeed(String username, String feed);
	public List<Feedback> getFeed();
}
