package com.uportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uportal.domain.Feedback;

public class FeedbackRowMapper implements RowMapper<Feedback> {  
	@Override  
	 public Feedback mapRow(ResultSet resultSet, int line) throws SQLException {  
		FeedbackExtractor feedExtractor = new FeedbackExtractor();  
		return feedExtractor.extractData(resultSet);  
	 }  
}
