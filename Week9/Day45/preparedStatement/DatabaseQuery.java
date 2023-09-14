package preparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseQuery implements DatabaseInfo {
	static private PreparedStatement insertStmt;
	static private PreparedStatement deleteStmt;
	static private PreparedStatement updateStmt;
	static private PreparedStatement selectStmt;
	static private Scanner sc;
	static public void initialize(PreparedStatement newInsertStmt, PreparedStatement newDeleteStmt, PreparedStatement newUpdateStmt, PreparedStatement newSelectStmt, Scanner newSc) {
		insertStmt = newInsertStmt;
		deleteStmt = newDeleteStmt;
		updateStmt = newUpdateStmt;
		selectStmt = newSelectStmt;
		sc = newSc;
	}
	static public void insert() throws SQLException {
		insertStmt.setString(1, sc.nextLine());
		insertStmt.setString(2, sc.nextLine());
		insertStmt.setString(3, sc.nextLine());
		insertStmt.executeUpdate();
	}
	
	static public void delete() throws SQLException {
		System.out.print("삭제할 줄번호를 입력하세요. :");
		deleteStmt.setInt(1, sc.nextInt());
		sc.nextLine();
		deleteStmt.executeUpdate();
	}
	
	static public void update() throws SQLException {
		System.out.print("수정할 줄번호를 입력하세요. :");
		updateStmt.setInt(2, sc.nextInt());
		sc.nextLine();
		System.out.print("새 내용을 입력하세요. :");
		updateStmt.setString(1, sc.nextLine());
		updateStmt.executeUpdate();
	}
	
	static public void select() {
		try(ResultSet rs = selectStmt.executeQuery()) {
			while(rs.next()) {
				System.out.printf("번호:%d\t작성자:%s\t제목:%s\t내용:%s\t시간:%s\t조회수:%d\n",rs.getInt("NO"),rs.getString("NAME"),rs.getString("TITLE"), rs.getString("CONTENTS"), rs.getString("wTIME"), rs.getInt("rCnt"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
