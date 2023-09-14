package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

interface DatabaseInfo{
	String DATABASE = "project";
	String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?serverTimezone=UTC";
	String USER = "root";
	String PASSWORD = "1234";
	String TABLE = "BOARD";
}

interface Command {
	int INSERT = 1;
	int DELETE = 2;
	int UPDATE = 3;
	int SELECT = 4;
	int QUIT = 5;
}

public class JdbcPreparedStatement implements DatabaseInfo, Command{

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String insertQuery ="INSERT INTO " + TABLE + "(name, title, contents) VALUES(?,?,?)";
		String deleteQuery ="DELETE FROM " + TABLE + " WHERE no = ?";
		String updateQuery ="UPDATE " + TABLE + " SET contents = ? WHERE no = ?";
		String selectQuery ="SELECT * FROM " + TABLE + " ORDER BY no DESC";
		
		boolean run = true;
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement insertStmt =conn.prepareStatement(insertQuery);
				PreparedStatement delteStmt =conn.prepareStatement(deleteQuery);
				PreparedStatement updateStmt =conn.prepareStatement(updateQuery);
				PreparedStatement slectStmt =conn.prepareStatement(selectQuery);
				Scanner sc = new Scanner(System.in)) {
				
				DatabaseQuery.initialize(insertStmt, delteStmt, updateStmt, slectStmt, sc);
				
				while(run) {
					System.out.print("삽입 1, 삭제 2, 수정 3, 출력 4, 종료 5:");
					int cmd = sc.nextInt();
					sc.nextLine();
					switch(cmd) {
					case INSERT : DatabaseQuery.insert(); break;
					case DELETE : DatabaseQuery.delete(); break;
					case UPDATE : DatabaseQuery.update(); break;
					case SELECT : DatabaseQuery.select(); break;
					case QUIT : run = false;
					}
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
