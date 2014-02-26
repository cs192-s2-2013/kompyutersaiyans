package com.uportal.services;


import org.springframework.beans.factory.annotation.Autowired;  

import com.uportal.dao.AdminRequestDao;  

public class AdminRequestServiceImpl implements AdminRequestService{

	 @Autowired
	 AdminRequestDao adminrequestdao;
	
	 @Override
	 public int addAdminRequest(int userid,int typeid) {
		 return adminrequestdao.addAdminRequest(userid,typeid);
	 }
	 
	 @Override
	 public void deleteAdminRequest(String userid,String typeid) {
		 adminrequestdao.deleteAdminRequest(userid,typeid);
	 }
	 
	 @Override
	 public void addAdmin(String userid, String typeid) {
		 adminrequestdao.addAdmin(userid, typeid);
	 }
}
