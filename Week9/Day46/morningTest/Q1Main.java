package morningTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

interface DatabaseInfo {
	String Database = "jdbcTest";
	String URL = "jdbc:mysql://localhost:3306/" + Database + "?serverTimezone=UTC";
	String USER = "root";
	String PASSWORD = "1234";
	String TABLE = "BOARD";
}

interface Command {
	int INSERT = 1;
	int DELETE = 4;
	int UPDATE = 3;
	int SELECT = 2;
	int CREATE_TABLE = 5;
	int DROP_TABLE = 6;
	int QUIT = 7;
}

public class Q1Main implements DatabaseInfo, Command{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String insertQuery = "INSERT INTO " + TABLE + "(name, title, contents) VALUES(?,?,?)";
		String deleteQuery = "DELETE FROM " + TABLE + " WHERE no = ?";
		String updateQuery = "UPDATE " + TABLE + " SET contents = ? WHERE no = ?";
		String selectQuery = "SELECT * FROM " + TABLE +" ORDER BY no DESC";
		
		
		boolean run = true;
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
				PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
				PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
				PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
				Scanner sc = new Scanner(System.in);
				) {
			DatabaseQuery dq = DatabaseQuery.getDatabaseQuery(insertStmt, deleteStmt, updateStmt, selectStmt, sc);
			while(run) {
				System.out.println("메뉴를 선택하세요.\r\n"
						+ "1. 쓰기\r\n"
						+ "2. 조회\r\n"
						+ "3. 수정\r\n"
						+ "4. 삭제\r\n"
						+ "5. test 테이블 생성\r\n"
						+ "6. test 테이블 삭제\r\n"
						+ "7. 종료\r\n"
						+ "선택 :");
				int cmd = Integer.parseInt(sc.nextLine());
				switch(cmd) {
				case INSERT : dq.insert(); break;
				case DELETE : dq.delete(); break;
				case UPDATE : dq.update(); break;
				case SELECT : dq.select(); break;
				case CREATE_TABLE : dq.createTable(); break;
				case DROP_TABLE : dq.dropTable(); break;
				case QUIT : run = false;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
