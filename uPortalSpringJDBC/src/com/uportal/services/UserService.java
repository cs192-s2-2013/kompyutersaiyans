package com.uportal.services;
import java.util.List;
import com.uportal.domain.User;
public interface UserService {
	public void insertData(User user);
	public List<User> getUserList();
	public void deleteData(String id);
	public User getUser(String id);
	public void updateData(User user);
	public void initDB();
}