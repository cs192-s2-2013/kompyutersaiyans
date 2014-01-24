package com.uportal.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.uportal.domain.User;
import com.uportal.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;
	
	public void initDB()
	{
		try
		{
			Connection cxn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			Statement st = cxn.createStatement();
			System.out.println("connection established");
			st.execute("CREATE DATABASE IF NOT EXISTS userdb;");
			st.execute("USE userdb;");
			st.execute("CREATE user 'java'@'localhost' identified by 'root';");
			st.execute("grant all privileges on userdb to 'java'@'localhost' identified by 'root' with grant option;");
		}
		catch(Exception e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

	public void insertData(User user) {

		String sql = "INSERT INTO user "
				+ "(firstname, lastname, email, username, password) VALUES (?,?,?,?,?);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword() });

	}
	
	/*public boolean insertData(User user) {
		boolean t = true;
		String sql = "INSERT INTO user "
				+ "(firstname, lastname, email, username, password) VALUES (?,?,?,?,?);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String check = "select count(*) from user where username = ?;";
		int result= jdbcTemplate.queryForInt(check, new Object[]{String.valueOf(user.getUsername())});
		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword() });

	}*/

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
