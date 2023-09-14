package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
	int SELECT = 2;
	int QUIT = 3;
}

public class JdbcInsertSelect implements DatabaseInfo ,Command{
	public static void main(String[] args) {
		boolean run = true;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				Statement stmt = conn.createStatement();
				Scanner sc = new Scanner(System.in)) {
			DatabaseQuery.setStmt(stmt);
			DatabaseQuery.setTable(TABLE);
			while(run) {
				System.out.print("입력 1, 조회 2, 종료 3 :");
				int cmd = sc.nextInt();
				sc.nextLine();
				switch (cmd) {
				case INSERT : DatabaseQuery.insert(sc.nextLine(), sc.nextLine(), sc.nextLine());
				break;
				case SELECT : DatabaseQuery.showAll();
				break;
				case QUIT : run = false; 
				}
			}


		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
	}

}
