package com.uportal.dao;

import com.uportal.domain.Feedback;

import java.util.List;


public interface FeedbackDao {
	public void addFeed(String username, String feed);
	public List<Feedback> getFeed();
}
