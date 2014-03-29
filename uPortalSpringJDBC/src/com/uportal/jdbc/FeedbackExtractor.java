package com.uportal.jdbc;

import java.sql.ResultSet;  
import java.sql.SQLException;  

import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  

import com.uportal.domain.Feedback;

public class FeedbackExtractor implements ResultSetExtractor<Feedback>{
	public Feedback extractData(ResultSet resultSet) throws SQLException,  
	   DataAccessException {  
	    
	  Feedback feed = new Feedback();
	  
	  feed.setUsername(resultSet.getString(1));
	  feed.setFeed(resultSet.getString(2));
	  
	  return feed;  
	 }
}
