package com.loginboard.www.daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao implements DbSetting {
	private DataSource ds;

	private MemberDao() {
		{
			InitialContext ic;
			try {
				ic = new InitialContext();
				ds = (DataSource) ic.lookup("java:comp/env/" + CONNECTION_POOL_NAME);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getMemberDao() {
		return dao;
	}

	public void insertMember(MemberDto dto) {
		String insertMemberQuery = "INSERT INTO " + MEMBER_TABLE + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement insertMemberStmt = conn.prepareStatement(insertMemberQuery);
			insertMemberStmt.setString(1, dto.getName());
			insertMemberStmt.setString(2, dto.getId());
			insertMemberStmt.setString(3, dto.getNickname());
			insertMemberStmt.setString(4, dto.getPassword());
			insertMemberStmt.setString(5, dto.getEmail());
			insertMemberStmt.setString(6, dto.getPostNum());
			insertMemberStmt.setString(7, dto.getDetailAddress());
			insertMemberStmt.setString(8, dto.getBirthday());
			insertMemberStmt.setString(9, dto.getPhone());
			insertMemberStmt.setInt(10, dto.getSex());
			insertMemberStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isUnique(MemberDto dto) {
		String selectIdQuery = "SELECT EXISTS (SELECT 1 FROM " + MEMBER_TABLE + " WHERE id = ?)";
		boolean rslt = true;
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectIdStmt = conn.prepareStatement(selectIdQuery);
			selectIdStmt.setString(1, dto.getId());
			try (ResultSet rs = selectIdStmt.executeQuery()) {
				if (rs.next())
					if (rs.getInt(1) == 1)
						rslt = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}

	public boolean isCorrectLogin(MemberDto dto) {
		String selectMemberQuery = "SELECT id, password FROM " + MEMBER_TABLE + " WHERE id = ?";
		boolean rslt = false;
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectMemberStmt = conn.prepareStatement(selectMemberQuery);
			selectMemberStmt.setString(1, dto.getId());
			try (ResultSet rs = selectMemberStmt.executeQuery()) {
				if (rs.next()) {
					if (dto.getPassword().equals(rs.getString("password")))
						rslt = true;
				} else
					rslt = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}

	public MemberDto selectMember(String id) {
		MemberDto member = new MemberDto();
		String selectMemberQuery = "SELECT * FROM " + MEMBER_TABLE + " WHERE id = ?";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectMemberStmt = conn.prepareStatement(selectMemberQuery);
			selectMemberStmt.setString(1, id);
			try (ResultSet rs = selectMemberStmt.executeQuery()) {
				if (rs.next()) {
					member.setName(rs.getString("name"));
					member.setId(id);
					member.setNickname(rs.getString("nickname"));
					member.setEmail(rs.getString("email"));
					member.setPostNum(rs.getString("postNum"));
					member.setDetailAddress(rs.getString("detailAddress"));
					member.setBirthday(rs.getString("birthday"));
					member.setPhone(rs.getString("phone"));
					member.setSex(rs.getInt("sex"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public void updateMember(MemberDto dto) {
		String updateMemberQuery = "UPDATE " + MEMBER_TABLE + " SET nickname = ?, email = ?, postNum = ?, detailAddress = ?, birthday = ?, phone = ?, sex = ? WHERE id = ?";
		try(Connection conn = ds.getConnection()){
			PreparedStatement updateMemberStmt = conn.prepareStatement(updateMemberQuery);
			updateMemberStmt.setString(1, dto.getNickname());
			updateMemberStmt.setString(2, dto.getEmail());
			updateMemberStmt.setString(3, dto.getPostNum());
			updateMemberStmt.setString(4, dto.getDetailAddress());
			updateMemberStmt.setString(5, dto.getBirthday());
			updateMemberStmt.setString(6, dto.getPhone());
			updateMemberStmt.setInt(7, dto.getSex());
			updateMemberStmt.setString(8, dto.getId());
			updateMemberStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
