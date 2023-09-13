import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로드 실패");
//		}
		try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project?serverTimezone=UTC", "root", "1234")){
			System.out.println("DONE");
		} catch (SQLException e) {
			System.out.println("커넥션 객체 생성 실패");
		}
	}

}
