package com.uportal.dao;

public interface AdminRequestDao {
	 public int addAdminRequest(int userid,int typeid);
	 public void deleteAdminRequest(String userid,String typeid);
	 public void addAdmin(String userid, String typeid);
}
