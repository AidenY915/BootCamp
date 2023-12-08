package com.ajaxsearch.www.daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao {
	private DataSource ds;
	private final static String CONNECTION_POOL = "jdbc/project";
	private final static String TABLE = "user";

	private UserDao() {
		try {
		InitialContext ic = new InitialContext();
		ds = (DataSource) ic.lookup("java:comp/env/" + CONNECTION_POOL); 
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	private static UserDao dao = new UserDao();
	public static UserDao getUserDao() {return dao;}
	
	
	public List<UserDto> selectUsers(String name) {
		List<UserDto> users = new ArrayList<UserDto>();
		String selectUsersQuery = "SELECT * FROM " + TABLE + " WHERE userName LIKE '%" + name + "%'";
		try(Connection conn = ds.getConnection();
				PreparedStatement selectUsersStmt = conn.prepareStatement(selectUsersQuery)){
			try(ResultSet rs = selectUsersStmt.executeQuery()){
				while(rs.next()) {
					UserDto user = new UserDto();
					user.setUserName(rs.getString("userName"));
					user.setUserAge(rs.getInt("userAge"));
					user.setUserGender(rs.getString("userGender"));
					user.setUserEmail(rs.getString("userEmail"));
					users.add(user);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
