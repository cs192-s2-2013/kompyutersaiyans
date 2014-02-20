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
	public List<ValueTuple> getDeptList(int collegeid){
		return resourcedao.getDeptList(collegeid);
	}
	
	@Override
	public List<ValueTuple> getCourseList(){
		return resourcedao.getCourseList();
	}
	
	@Override
	public List<ValueTuple> getHotlines(){
		return resourcedao.getHotlines();
	}
	
	@Override
	public int getDeptCount(int collegeid){
		return resourcedao.getDeptCount(collegeid);
	}
	
	@Override
	public String getDept(int deptid){
		return resourcedao.getDept(deptid);
	}
	
	public String getCollege(int collegeid){
		return resourcedao.getCollege(collegeid);
	}
}
