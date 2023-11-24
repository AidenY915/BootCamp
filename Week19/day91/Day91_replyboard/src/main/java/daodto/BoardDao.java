package daodto;

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
	private DataSource ds;
	private final static String TABLE = "board";

	private BoardDao() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/replyboard");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static BoardDao boardDao = new BoardDao();

	public static BoardDao getBoardDao() {
		return boardDao;
	}

	private void updateGroupNum(Connection conn) throws SQLException {
		String updateGroupNumQuery = "UPDATE " + TABLE + " SET groupNum = no WHERE groupNum = 0";
		PreparedStatement updateGroupNumStmt = conn.prepareStatement(updateGroupNumQuery);
		updateGroupNumStmt.executeUpdate();
	}
	private void updateStepNums(Connection conn, BoardDto dto) throws SQLException{
		String updateStepNumQuery = "UPDATE " + TABLE + " SET stepNum = stepNum + 1 WHERE groupNum = ? and stepNum >= ?";
		PreparedStatement updateStepNumStmt = conn.prepareStatement(updateStepNumQuery);
		updateStepNumStmt.setInt(1, dto.getGroupNum());
		updateStepNumStmt.setInt(2, dto.getStepNum());
		updateStepNumStmt.executeUpdate();
	}

	public void insertBoard(BoardDto dto) {
		String insertQuery = "INSERT INTO " + TABLE
				+ "(writer, title, content, groupNum, stepNum, indentNum, parentNum) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
			insertStmt.setString(1, dto.getWriter());
			insertStmt.setString(2, dto.getTitle());
			insertStmt.setString(3, dto.getContent());
			insertStmt.setInt(4, dto.getGroupNum());
			insertStmt.setInt(5, dto.getStepNum());
			insertStmt.setInt(6, dto.getIndentNum());
			insertStmt.setInt(7, dto.getParentNum());
			
			updateStepNums(conn, dto);
			insertStmt.executeUpdate();
			updateGroupNum(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDto> selectBoards() {
		List<BoardDto> boards = new ArrayList<BoardDto>();
		String selectBoardsQuery = "SELECT * FROM " + TABLE + " ORDER BY groupNum DESC, stepNum ASC";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectBoardsStmt = conn.prepareStatement(selectBoardsQuery);
			try (ResultSet rs = selectBoardsStmt.executeQuery()) {
				while (rs.next()) {
					BoardDto board = new BoardDto();
					board.setNo(rs.getInt("no"));
					board.setWriter(rs.getString("writer"));
					board.setTitle(rs.getString("title"));
					board.setCreatedDate(rs.getTimestamp("createdDate"));
					board.setViews(rs.getInt("views"));
					board.setIndentNum(rs.getInt("indentNum"));
					boards.add(board);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	
	public BoardDto selectBoard(int no) {
		String selectBoardQuery = "SELECT * FROM " + TABLE + " WHERE no = '" + no + "'";
		BoardDto board = new BoardDto();
		try(Connection conn = ds.getConnection()){
			PreparedStatement selectBoardStmt = conn.prepareStatement(selectBoardQuery);
			try(ResultSet rs = selectBoardStmt.executeQuery()){
				if(rs.next()) {
					board.setNo(no);
					board.setWriter(rs.getString("writer"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setCreatedDate(rs.getTimestamp("createdDate"));
					board.setGroupNum(rs.getInt("groupNum"));
					board.setStepNum(rs.getInt("stepNum"));
					board.setIndentNum(rs.getInt("indentNum"));
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	public void updateViews(int no) {
		String updateViewsQuery = "UPDATE " + TABLE + " SET views = views + 1 WHERE no = '" + no + "'";
		try (Connection conn = ds.getConnection()) {
			PreparedStatement updateViewsStmt = conn.prepareStatement(updateViewsQuery);
			updateViewsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void deleteBoards(Connection conn ,int no) throws SQLException{
		String selectChildBoardsQuery = "SELECT no FROM " + TABLE + " WHERE parentNum = '" + no + "'";
		PreparedStatement selectChildBoardsStmt = conn.prepareStatement(selectChildBoardsQuery);
		try(ResultSet rs = selectChildBoardsStmt.executeQuery()){
			while(rs.next()) {
				int childNo = rs.getInt("no");
				deleteBoards(conn, childNo);
			}
		}
		String deleteBoardQuery = "DELETE FROM " + TABLE + " WHERE no = '" + no + "'";
		PreparedStatement deleteBoardStmt = conn.prepareStatement(deleteBoardQuery);
		deleteBoardStmt.executeUpdate();
	}
	
	public void deleteBoard(int no) {
		try (Connection conn = ds.getConnection()) {
			deleteBoards(conn, no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
