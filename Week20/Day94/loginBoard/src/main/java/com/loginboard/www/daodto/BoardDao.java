package com.loginboard.www.daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao implements DbSetting {
	private DataSource ds;

	private BoardDao() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/" + CONNECTION_POOL_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static BoardDao dao = new BoardDao();

	public static BoardDao getBoardDao() {
		return dao;
	}

	public List<BoardDto> selectBoards(int page, String searchMode, String search[]) {
		List<BoardDto> boards = new ArrayList<>();

		String searchedColumn[] = new String[] { "title", "content" };
		if (searchMode.equals("w"))
			searchedColumn = new String[] { "nickname" };

		String selectBoardsQuery = "SELECT no, nickname, title, createdDate, views, groupNum, stepNum, indentNum FROM " + BOARD_TABLE
				+ " INNER JOIN " + MEMBER_TABLE + " ON " + BOARD_TABLE + ".id = " + MEMBER_TABLE + ".id";
		String whereStr = search.length == 0 ? "" : " WHERE";
		for (int i = 0; i < search.length; i++) {
			for (int j = 0; j < searchedColumn.length; j++) {
				if(!(i==0 && j ==0))
					whereStr += " or";
				whereStr += " " + searchedColumn[j] + " LIKE '%" + search[i] + "%'";
			}
		}
		String orderStr = " ORDER BY groupNum DESC, stepNum ASC LIMIT 10 OFFSET " + (page * 10);
		selectBoardsQuery += whereStr + orderStr;

		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectBoardsStmt = conn.prepareStatement(selectBoardsQuery);
			try (ResultSet rs = selectBoardsStmt.executeQuery()) {
				while (rs.next()) {
					BoardDto board = new BoardDto();
					board.setNo(rs.getInt("no"));
					board.setNickname(rs.getString("nickname"));
					board.setTitle(rs.getString("title"));
					board.setViews(rs.getInt("views"));
					board.setCreatedDate(rs.getTimestamp("createdDate"));
					board.setGroupNum(rs.getInt("groupNum"));
					board.setStepNum(rs.getInt("StepNum"));
					board.setIndentNum(rs.getInt("indentNum"));
					boards.add(board);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}

	private void updateGroupNum(Connection conn) throws SQLException {
		String updateGroupNumQuery = "UPDATE " + BOARD_TABLE + " SET groupNum = no WHERE groupNum = 0";
		conn.prepareStatement(updateGroupNumQuery).executeUpdate();
	}

	private void updateStepNums(Connection conn, BoardDto board) throws SQLException {
		String updateStepNumsQuery = "UPDATE " + BOARD_TABLE
				+ " SET stepNum = stepNum+1 WHERE groupNum = ? and stepNum >= ?";
		PreparedStatement updateStepNumsStmt = conn.prepareStatement(updateStepNumsQuery);
		updateStepNumsStmt.setInt(1, board.getGroupNum());
		updateStepNumsStmt.setInt(2, board.getStepNum());
		updateStepNumsStmt.executeUpdate();
	}

	public void insertBoard(BoardDto dto) {
		String insertBoardQuery = "INSERT INTO " + BOARD_TABLE
				+ "(id, title, content, groupNum, stepNum, indentNum) VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement insertBoardStmt = conn.prepareStatement(insertBoardQuery);
			insertBoardStmt.setString(1, dto.getId());
			insertBoardStmt.setString(2, dto.getTitle());
			insertBoardStmt.setString(3, dto.getContent());
			insertBoardStmt.setInt(4, dto.getGroupNum());
			insertBoardStmt.setInt(5, dto.getStepNum());
			insertBoardStmt.setInt(6, dto.getIndentNum());

			updateStepNums(conn, dto);
			insertBoardStmt.executeUpdate();
			updateGroupNum(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public BoardDto selectBoard(int no) {
		String selectBoardQuery = "SELECT * FROM " + BOARD_TABLE + " WHERE no = ?";
		BoardDto board = new BoardDto();
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectBoardStmt = conn.prepareStatement(selectBoardQuery);
			selectBoardStmt.setInt(1, no);
			try (ResultSet rs = selectBoardStmt.executeQuery()) {
				if (rs.next()) {
					board.setNo(no);
					board.setId(rs.getString("id"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setCreatedDate(rs.getTimestamp("createdDate"));
					board.setGroupNum(rs.getInt("groupNum"));
					board.setStepNum(rs.getInt("stepNum"));
					board.setIndentNum(rs.getInt("indentNum"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	public void updateViews(BoardDto board) {
		String updateViewsQuery = "UPDATE " + BOARD_TABLE + " SET views = views+1 WHERE no = ?";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement updateViewsStmt = conn.prepareStatement(updateViewsQuery);
			updateViewsStmt.setInt(1, board.getNo());
			updateViewsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(int no) {
		String deleteBoardQuery = "DELETE FROM " + BOARD_TABLE + " WHERE no = ?";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement deleteBoardStmt = conn.prepareStatement(deleteBoardQuery);
			deleteBoardStmt.setInt(1, no);
			deleteBoardStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int selectNumOfPages(String searchMode, String search[]) {
		int rslt = 0;
		
		String searchedColumn[] = new String[] { "title", "content" };
		if (searchMode.equals("w"))
			searchedColumn = new String[] { "nickname" };
		
		String selectCountQuery = "SELECT COUNT(*) FROM " + BOARD_TABLE
				+ " INNER JOIN " + MEMBER_TABLE + " ON " + BOARD_TABLE + ".id = " + MEMBER_TABLE + ".id";
		String whereStr = search.length == 0 ? "" : " WHERE";
		for (int i = 0; i < search.length; i++) {
			for (int j = 0; j < searchedColumn.length; j++) {
				if(!(i==0 && j ==0))
					whereStr += " or";
				whereStr += " " + searchedColumn[j] + " LIKE '%" + search[i] + "%'";
			}
		}
		selectCountQuery += whereStr;
		
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectCountStmt = conn.prepareStatement(selectCountQuery);
			try(ResultSet rs = selectCountStmt.executeQuery()) {
				if(rs.next())
					rslt = rs.getInt("COUNT(*)");
					rslt = rslt / 10 + (rslt % 10 == 0 ? 0 : 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}

}
