package com.daodto.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO{
	private final static String DB = "daodto";
	private final static String DB_USER = "root";
	private final static String DB_PASSWORD = "0000";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB+"?serverTimezone=Asia/Seoul";
	private final static String DB_TABLE = DB+".board";
	
	private static BoardDAO boardDAO = new BoardDAO();
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}
	private BoardDAO() {}
	
	private ArrayList<BoardDTO> boards = new ArrayList<>();
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> getBoards() {
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			String selectBoardsQuery = "SELECT * FROM " + DB_TABLE;
			PreparedStatement pStmt = conn.prepareStatement(selectBoardsQuery);
			try(ResultSet rs = pStmt.executeQuery()){
				boards.clear();
				while(rs.next()) {
					BoardDTO newBoard = new BoardDTO(rs.getInt("no"), rs.getString("writer"), rs.getString("title"),rs.getString("content"),rs.getString("createdDate"),rs.getInt("views"), rs.getString("password"));
					boards.add(newBoard);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	public void createBoard(String writer, String title, String content, String password) {
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			String insertBoardQuery = "INSERT INTO " + DB_TABLE + "(writer, title, content, password) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(insertBoardQuery);
			pStmt.setString(1, writer);
			pStmt.setString(2, title);
			pStmt.setString(3, content);
			pStmt.setString(4, password);
			pStmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

