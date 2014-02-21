package com.uportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uportal.domain.ValueTuple;
import com.uportal.jdbc.ValueTupleRowMapper;

public class ResourceDaoImpl implements ResourceDao{
	@Autowired
	DataSource dataSource;
	
	public List<ValueTuple> getCollegeList() {
		ArrayList<ValueTuple> collegeList = new ArrayList<ValueTuple>();
		String sql = "select * from colleges";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		collegeList = (ArrayList<ValueTuple>) jdbcTemplate.query(sql, new ValueTupleRowMapper());
		return collegeList;
	}
	
	public List<ValueTuple> getDeptList(int collegeid) {
		ArrayList<ValueTuple> deptList = new ArrayList<ValueTuple>();
		String sql = "select deptid,deptname,collegeid from departments where collegeid=" + collegeid;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		deptList = (ArrayList<ValueTuple>) jdbcTemplate.query(sql, new ValueTupleRowMapper());
		return deptList;
	}
	
	public List<ValueTuple> getCourseList(int deptid) {
		ArrayList<ValueTuple> courseList = new ArrayList<ValueTuple>();
		String sql = "select courseid,coursename,deptid from courses where deptid=" + deptid;

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		courseList = (ArrayList<ValueTuple>) jdbcTemplate.query(sql, new ValueTupleRowMapper());
		return courseList;
	}
	
	public int getDeptCount(int collegeid){
		String sql = "select count(*) from departments where collegeid=" + collegeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCourse(int courseid){
		String sql = "select coursename from courses where courseid=" + courseid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public String getDept(int deptid){
		String sql= "select deptname from departments where deptid="+ deptid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public String getCollege(int collegeid){
		String sql= "select collegename from colleges where collegeid="+ collegeid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public List<ValueTuple> getHotlines(){
		ArrayList<ValueTuple> hotlines = new ArrayList<ValueTuple>();
		String sql = "select * from hotlines";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		hotlines = (ArrayList<ValueTuple>) jdbcTemplate.query(sql, new ValueTupleRowMapper());
		return hotlines;
	}

	@Override
	public int getHomePageCounter() {
		String sql = "select views from hitcounter where page=\'homepage\'";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql);
	}

	@Override
	public void updateHomePageCounter(int views) {
		 String updateCounter = "update hitcounter set views="+views+" where page=\'homepage\'";
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 jdbcTemplate.update(updateCounter);
	}
}
