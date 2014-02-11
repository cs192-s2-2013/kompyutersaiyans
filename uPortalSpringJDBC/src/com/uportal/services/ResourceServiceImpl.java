package com.uportal.services;

import java.util.List;
import com.uportal.domain.ValueTuple;
import org.springframework.beans.factory.annotation.Autowired;  
import com.uportal.dao.ResourceDao; 

public class ResourceServiceImpl implements ResourceService {
	@Autowired
	ResourceDao resourcedao;
	
	@Override
	public List<ValueTuple> getCollegeList(){
		return resourcedao.getCollegeList();
	}
	
	@Override
	public List<ValueTuple> getDeptList(){
		return resourcedao.getDeptList();
	}
	
	@Override
	public List<ValueTuple> getCourseList(){
		return resourcedao.getCourseList();
	}
}
