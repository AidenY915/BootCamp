package com.write.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static final String DB = "daodto1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String DB_TABLE = DB + ".board";
	private static BoardDAO boardDAO;
	private BoardDAO() {}
	public static BoardDAO getBoardDAO() {
		if(boardDAO == null) boardDAO = new BoardDAO();
		return boardDAO;
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> getBoards() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>(10);
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		String selectBoardsQuery = "SELECT * FROM " + DB_TABLE;
		PreparedStatement selectBoardsStmt = conn.prepareStatement(selectBoardsQuery);
		try(ResultSet rs = selectBoardsStmt.executeQuery()){
			while(rs.next()) {
				BoardDTO board = new BoardDTO(rs.getInt("id"), rs.getString("writer"), rs.getString("title"), rs.getString("content"), rs.getTime("createdDate"), rs.getString("password"));
				boards.add(board);
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	
	public void insertBoard(String writer, String title, String content, String password) {
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String insertBoardQuery = "INSERT INTO " + DB_TABLE + "(writer, title, content, password) VALUES(?, ?, ?, ?)";
			PreparedStatement insertBoardStmt = conn.prepareStatement(insertBoardQuery);
			insertBoardStmt.setString(1, writer);
			insertBoardStmt.setString(2, title);
			insertBoardStmt.setString(3, content);
			insertBoardStmt.setString(4, password);
			insertBoardStmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return;
	}
	
	


}
