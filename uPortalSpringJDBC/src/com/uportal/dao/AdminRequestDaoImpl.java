package com.uportal.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminRequestDaoImpl implements AdminRequestDao {

	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings("deprecation")
	@Override
	public int addAdminRequest(int userid, int typeid) {
		String checkduplicate = "select count(*) from adminRequests where userid=" + userid + " and typeid=" + typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt(checkduplicate);
		if(count > 0)
			return count;
		else
		{
			String sql = "insert into adminRequests(userid,typeid) values (" + userid + "," + typeid + ")";
			jdbcTemplate.update(sql);
			return 0;
		}
	}
	
	@Override
	public void deleteAdminRequest(String userid,String typeid) {
		String sql = "delete from adminRequests where userid=" + userid + " and typeid=" + typeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void addAdmin(String userid, String typeid) {
		String sql = "insert into userRoles(userid,typeid) values (" + userid + "," + typeid + ")";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}
	
}
