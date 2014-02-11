package com.uportal.dao;

import java.util.List;
import com.uportal.domain.ValueTuple;

public interface ResourceDao {
	public List<ValueTuple> getCollegeList();
	public List<ValueTuple> getDeptList();
	public List<ValueTuple> getCourseList();
}
