package com.uportal.services;

import java.util.List;
import com.uportal.domain.ValueTuple;

public interface ResourceService {
	public List<ValueTuple> getCollegeList();
	public List<ValueTuple> getDeptList(int collegeid);
	public List<ValueTuple> getCourseList();
	public List<ValueTuple> getHotlines();
	public int getDeptCount(int collegeid);
	public String getDept(int deptid);
	public String getCollege(int collegeid);
	public int getHomePageCounter();
	public void updateHomePageCounter(int views);
}
