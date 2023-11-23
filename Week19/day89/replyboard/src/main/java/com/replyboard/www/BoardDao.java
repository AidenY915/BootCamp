package com.replyboard.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao boardDao = new BoardDao();
	private final static String DB = "replyboard";
	private final static String TABLE = "board";
	private DataSource dataSource;

	private BoardDao() {
	}

	public static BoardDao getBaordDao() {
		return boardDao;
	}

	{
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/" + DB);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void insertBoard(BoardDto dto) {
		try (Connection conn = dataSource.getConnection()) {
			String insertQuery = "INSERT INTO " + TABLE
					+ "(writer, title, content, password, groupNum, stepNum, indentNum) VALUES(?, ? , ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			pStmt.setString(1, dto.getWriter());
			pStmt.setString(2, dto.getTitle());
			pStmt.setString(3, dto.getContent());
			pStmt.setString(4, dto.getPassword());
			pStmt.setInt(5, dto.getGroupNum());
			pStmt.setInt(6, dto.getStepNum());
			pStmt.setInt(7, dto.getIndentNum());
			pStmt.executeUpdate();
			if(dto.getGroupNum() == 0) {
				String updateGroupNumQuery = "UPDATE " + TABLE + " SET groupNum = no WHERE groupNum = 0";
				pStmt.executeUpdate(updateGroupNumQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDto> selectBoards() {
		List<BoardDto> boards = new ArrayList<>();
		try (Connection conn = dataSource.getConnection()) {
			String selectBoardsQuery = "SELECT * FROM " + TABLE +" ORDER BY groupNum DESC, stepNum ASC";
			PreparedStatement pStmt = conn.prepareStatement(selectBoardsQuery);
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					BoardDto board = new BoardDto(rs.getInt("no"), rs.getString("writer"), rs.getString("title"),
							rs.getString("content"), rs.getString("password"), rs.getTimestamp("createdDate"),
							rs.getInt("groupNum"), rs.getInt("stepNum"),rs.getInt("indentNum"));
					boards.add(board);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	
	public BoardDto selectBoard(int no) {
		BoardDto board = null;
		try (Connection conn = dataSource.getConnection()) {
			String selectBoardsQuery = "SELECT * FROM " + TABLE + " WHERE no = ?";
			PreparedStatement pStmt = conn.prepareStatement(selectBoardsQuery);
			pStmt.setInt(1, no);
			try (ResultSet rs = pStmt.executeQuery()) {
				if (rs.next()) {
					board = new BoardDto(rs.getInt("no"), rs.getString("writer"), rs.getString("title"),
							rs.getString("content"), rs.getString("password"), rs.getTimestamp("createdDate"),
							rs.getInt("groupNum"), rs.getInt("stepNum"), rs.getInt("IndentNum"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public void updateStepNum(BoardDto dto) {
		try (Connection conn = dataSource.getConnection()) {
			String updateStepNumsQuery = "UPDATE " + TABLE + " SET stepNum = stepNum+1 WHERE stepNum >= " + dto.getStepNum() +" and groupNum = " + dto.getGroupNum();
			System.out.println(updateStepNumsQuery);
			PreparedStatement pStmt = conn.prepareStatement(updateStepNumsQuery);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
