package com.uportal.dao;

import java.util.List;

import com.uportal.domain.ValueTuple;

public interface ResourceDao {
	public List<ValueTuple> getCollegeList();
	public List<ValueTuple> getDeptList(int collegeid);
	public List<ValueTuple> getCourseList(int deptid);
	public List<ValueTuple> getHotlines();
	public int getDeptCount(int collegeid);
	public String getDept(int deptid);
	public String getCollege(int collegeid);
	public List<String> getRoles(int userid);
	public int getHomePageCounter();
	public void updateHomePageCounter(int views);
}
