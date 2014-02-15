package com.uportal.dao;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.uportal.domain.User;
import com.uportal.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	private boolean isDBinit = false;
	
	@Autowired
	DataSource dataSource;
	
	public int insertData(User user) {
		
		/*if(!isDBinit)//initialize db; create table; create user
		{
			try
			{
				System.out.println("DB init");
				Connection cxn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
				Statement st = cxn.createStatement();
				System.out.println("connection established");
				st.execute("CREATE DATABASE IF NOT EXISTS userdb;");
				st.execute("USE userdb;");
				st.execute("CREATE table if not exists user (	    userid int not null auto_increment,    firstname varchar(255) DEFAULT null,    lastname varchar(255) DEFAULT null,    email varchar(255) DEFAULT null,    username varchar(255) DEFAULT null,    password varchar(255) DEFAULT null,    primary key (userid));");
				st.execute("alter table userdb.user add column enabled tinyint(1) default true;");
				st.execute("alter table userdb.user add column access varchar(50) default 'ROLE_USER';");
				st.execute("CREATE user 'java'@'localhost' identified by 'eclipseisabitch';");
				st.execute("grant all privileges on userdb to 'java'@'localhost' with grant option;");
				st.execute("INSERT INTO `user` (`firstname`, `lastname`, `email`, `username`, `password`) VALUES ('Sherlyne', 'Francia', 'sherlyne@francia.com', 'sherlyne', 'francia'),	('Denise', 'Francisco', 'denise@francisco.com', 'denise', 'francisco'),	('Erwin', 'Sanchez', 'erwin@sanchez.com', 'erwin', 'sanchex'),	('Frank', 'Rayo', 'frank@rayo.com', 'frank', 'rayo'),	('Mark', 'Navata', 'mark@navata.com', 'mark', 'navata');");
				cxn.close();
				System.out.println("OK");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			isDBinit = true;
		}*/
		String department = user.getDepartment();
		String dept = department.replaceAll("[^0-9]", "");
		String sql = "INSERT INTO users "
				+ "(firstname, lastname, email, username, password, collegeid, departmentid ) VALUES (?,?,?,?,?,?,?);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String usernameCheck = "select count(*) from users where username = ?;";
		int usernameResult= jdbcTemplate.queryForInt(usernameCheck, new Object[]{String.valueOf(user.getUsername())});
		final String emailCheck = "select count(*) from users where email = ?;";
		int emailResult= jdbcTemplate.queryForInt(emailCheck, new Object[]{String.valueOf(user.getEmail())});
		
		if (usernameResult == 0 && emailResult == 0){
			ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
			String hashedPassword = passwordEncoder.encodePassword(user.getPassword(),null);
			jdbcTemplate.update(
					sql,
					new Object[] { user.getFirstName(), user.getLastName(),
							user.getEmail(), user.getUsername(), hashedPassword, user.getCollege(), Integer.parseInt(dept) });
			sql = "select userid from users where username = ?";
			int userid = (int)jdbcTemplate.queryForInt(
					sql, new Object[] { user.getUsername() });
			sql = "select typeid from userTypes where typename = 'GENERAL'";
			int typeid = (int)jdbcTemplate.queryForInt(sql);
			sql = "INSERT INTO userRoles" 
					+ "(userid, typeid) VALUES (?,?)";
			
			jdbcTemplate.update(
					sql,
					new Object[] {userid, typeid}
					);
			return 0;
		}
		
		else if (usernameResult > 0 && emailResult > 0){
			return 3;
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
		String sql = "select * from users";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = (ArrayList<User>) jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void deleteData(String userid) {
		String sql = "delete from users where userid=" + userid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(User user) {

		String sql = "UPDATE users set firstname = ?,lastname = ?, email = ?, username = ?, password = ? where userid = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getUsername(), user.getPassword(), user.getUserId() });

	}

	@Override
	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select userid,firstname,lastname,email,username,password,college,department,course from users where userid= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}

}
