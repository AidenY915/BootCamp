package morningTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseQuery {
	
	static private DatabaseQuery dq;
	static public DatabaseQuery getDatabaseQuery(PreparedStatement insertStmt, PreparedStatement deleteStmt, PreparedStatement updateStmt,
			PreparedStatement selectStmt, Scanner sc) {
		if(dq == null)
			dq = new DatabaseQuery();
		dq.insertStmt = insertStmt;
		dq.deleteStmt = deleteStmt;
		dq.updateStmt = updateStmt;
		dq.selectStmt = selectStmt;
		dq.sc = sc;
		return dq;
	}
	private DatabaseQuery() {}
	
	private PreparedStatement insertStmt;
	private PreparedStatement deleteStmt;
	private PreparedStatement updateStmt;
	private PreparedStatement selectStmt;
	private Scanner sc;
	
	public void insert() throws SQLException {
		System.out.print("이름: ");
		insertStmt.setString(1, sc.nextLine());
		System.out.print("제목: ");
		insertStmt.setString(2, sc.nextLine());
		System.out.print("내용: ");
		insertStmt.setString(3, sc.nextLine());
		insertStmt.executeUpdate();
	}
	
	public void delete() throws SQLException {
		System.out.print("삭제할 글 번호: ");
		deleteStmt.setInt(1, Integer.parseInt(sc.nextLine()));
		deleteStmt.executeUpdate();
	}
	
	public void update() throws SQLException {
		System.out.print("수정할 글 번호: ");
		updateStmt.setInt(2, Integer.parseInt(sc.nextLine()));
		System.out.print("내용: ");
		updateStmt.setString(1, sc.nextLine());
		updateStmt.executeUpdate();
	}
	
	public void select() throws SQLException {
		try(ResultSet rs = selectStmt.executeQuery()){
			while(rs.next()) {
				System.out.printf("번호:%d\t작성자:%s\t제목:%s\t내용:%s\t작성시각:%s\t조회수:%d\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		}catch (SQLException e) {
			throw e;
		} 
	}
	
	public void createTable() throws SQLException{
		selectStmt.executeUpdate("CREATE TABLE TEST(no int AUTO_INCREMENT PRIMARY KEY)");
	}
	public void dropTable() throws SQLException{
		selectStmt.executeUpdate("DROP TABLE TEST");
	}
}
