package com.loginboard.www.daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {	
	private String CONNECTION_POOL_NAME = "jdbc/loginboard";
	private String TABLE = "member";
	private DataSource ds;
	private MemberDao() {
		{
			InitialContext ic;
			try {
				ic = new InitialContext();
				ds = (DataSource) ic.lookup("java:comp/env/"+CONNECTION_POOL_NAME);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static MemberDao dao = new MemberDao();
	public static MemberDao getMemberDao() {return dao;}
	
	public void insertMember(MemberDto dto) {
		String insertMemberQuery = "INSERT INTO " + TABLE + " VALUES(?, ?)";
		try(Connection conn = ds.getConnection()){
			PreparedStatement insertMemberStmt = conn.prepareStatement(insertMemberQuery);
			insertMemberStmt.setString(1, dto.getId());
			insertMemberStmt.setString(2, dto.getPassword());
			insertMemberStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUnique(MemberDto dto) {
		String selectIdQuery = "SELECT EXISTS (SELECT 1 FROM " + TABLE + " WHERE id = ?)";
		boolean rslt = true;
		try(Connection conn = ds.getConnection()){
			PreparedStatement selectIdStmt = conn.prepareStatement(selectIdQuery);
			selectIdStmt.setString(1, dto.getId());
			try(ResultSet rs = selectIdStmt.executeQuery()){
				if(rs.next())
					rslt = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}
	
	public boolean isCorrectLogin(MemberDto dto) {
		String selectMemberQuery = "SELECT id, password FROM " + TABLE + " WHERE id = ?";
		boolean rslt = false;
		try(Connection conn = ds.getConnection()){
			PreparedStatement selectMemberStmt = conn.prepareStatement(selectMemberQuery);
			selectMemberStmt.setString(1, dto.getId());
			try(ResultSet rs = selectMemberStmt.executeQuery()){
				if(rs.next()) {
					if(dto.getPassword().equals(rs.getString("password"))) rslt = true;
				}else rslt = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}
}
