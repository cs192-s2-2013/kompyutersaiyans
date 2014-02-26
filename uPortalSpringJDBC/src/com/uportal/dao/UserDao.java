package com.uportal.dao;

import java.util.List;
import com.uportal.domain.User;

public interface UserDao {
	public int insertData(User user);
	public List<User> getUserList();
	public void updateData(User user);
	public void deleteData(String id);
	public User getUser(String username);
	public int addAdminRequest(int userid,int typeid);
	public void deleteAdminRequest(String userid,String typeid);
}
