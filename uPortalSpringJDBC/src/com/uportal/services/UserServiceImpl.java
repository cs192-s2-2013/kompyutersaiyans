package com.uportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.uportal.dao.UserDao;
import com.uportal.domain.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public void insertData(User user) {
		userdao.insertData(user);
	}

	@Override
	public List<User> getUserList() {
		return userdao.getUserList();
	}

	@Override
	public void deleteData(String userid) {
		userdao.deleteData(userid);

	}

	@Override
	public User getUser(String userid) {
		return userdao.getUser(userid);
	}

	@Override
	public void updateData(User user) {
		userdao.updateData(user);

	}

	@Override
	public void initDB() {
		userdao.initDB();
	}

}
