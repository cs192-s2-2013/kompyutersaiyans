package com.uportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.uportal.domain.User;
import com.uportal.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	/*public void insertData(User user) {

		String sql = "INSERT INTO user "
				+ "(firstname, lastname, email, username, password) VALUES (?,?,?,?,?);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword() });

	}*/
	
	public int insertData(User user) {
		boolean t = true;
		String sql = "INSERT INTO user "
				+ "(firstname, lastname, email, username, password) VALUES (?,?,?,?,?);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String usernameCheck = "select count(*) from user where username = ?;";
		int usernameResult= jdbcTemplate.queryForInt(usernameCheck, new Object[]{String.valueOf(user.getUsername())});
		final String emailCheck = "select count(*) from user where email = ?;";
		int emailResult= jdbcTemplate.queryForInt(emailCheck, new Object[]{String.valueOf(user.getEmail())});
		
		if (usernameResult == 0 && emailResult == 0){
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(user.getPassword());
			jdbcTemplate.update(
					sql,
					new Object[] { user.getFirstName(), user.getLastName(),
							user.getEmail(), user.getUsername(), hashedPassword });
			return 0;
		}
		
		else if (usernameResult > 0){
			return 1;
		}
		
		else{
			return 2;
		}
		
	}

	public List<User> getUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from user";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = (ArrayList<User>) jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void deleteData(String userid) {
		String sql = "delete from user where userid=" + userid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(User user) {

		String sql = "UPDATE user set firstname = ?,lastname = ?, email = ?, username = ?, password = ? where userid = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword(), user.getUserId() });

	}

	@Override
	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where userid= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}

}
