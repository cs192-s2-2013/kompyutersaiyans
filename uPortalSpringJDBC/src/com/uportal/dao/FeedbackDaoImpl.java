package com.uportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uportal.domain.Feedback;
import com.uportal.jdbc.FeedbackRowMapper;

public class FeedbackDaoImpl implements FeedbackDao{
	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Override
	public void addFeed(String username, String feed) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into feedback(username,feed) values (\"" + username + "\",\"" + feed + "\")";
		jdbcTemplate.update(sql);
		
	}
	
	@Override
	public List<Feedback> getFeed(){
		ArrayList<Feedback> feeds = new ArrayList<Feedback>();
		String sql = "select username,feed from feedback";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		feeds = (ArrayList<Feedback>) jdbcTemplate.query(sql, new FeedbackRowMapper());
		return feeds;
	}
}
