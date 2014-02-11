package com.uportal.services;

import java.util.List;
import com.uportal.domain.ValueTuple;

public interface ResourceService {
	public List<ValueTuple> getCollegeList();
	public List<ValueTuple> getDeptList();
	public List<ValueTuple> getCourseList();

}
