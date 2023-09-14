package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

interface AccessInfo {
	static String database = "project";
	static String url = "jdbc:mysql://localhost:3306/"
			+database+"?serverTimezone=UTC";
	static String user = "root";
	static String password = "1234";
}

public class JdbcPractice implements AccessInfo{
	
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				Scanner sc =new Scanner(System.in)) {
			System.out.println(database + "연결");
			String sql = String.format("INSERT INTO BOARD(NAME, TITLE, CONTENTS) VALUES('%s', '%s', '%s')", sc.nextLine(),sc.nextLine(),sc.nextLine());
			System.out.println(sql);
			int rslt = stmt.executeUpdate(sql);
			System.out.println(rslt);
			sql = "SELECT * FROM BOARD";
			try(ResultSet rs = stmt.executeQuery(sql)) {
				while(rs.next()) {
					System.out.println(rs.getInt("no") + " " + rs.getString("Name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(url);
		}
		
		
	}

}
