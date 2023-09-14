package statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery implements DatabaseInfo {
	static private Statement stmt;
	static private String query;
	static private String table;
	static public void setStmt(Statement newStmt) {
		stmt = newStmt;
	}
	static public void setTable(String newTable) {
		table = newTable;
	}
	static public void insert(String name, String title, String contents) throws SQLException {
		query = String.format("INSERT INTO %s(NAME, TITLE, CONTENTS) VALUES('%s', '%s', '%s')",table, name, title, contents);
		stmt.executeUpdate(query);
	}
	
	static private ResultSet selectAll() throws SQLException {
		query = "SELECT * FROM " + table + " ORDER BY NO DESC";
		return stmt.executeQuery(query);
	}
	
	static public void showAll() {
		try(ResultSet rs = selectAll()) {
			while(rs.next()) {
				System.out.printf("%d %s %s %s %s\n",rs.getInt("NO"),rs.getString("NAME"),rs.getString("TITLE"), rs.getString("CONTENTS"), rs.getString("wTIME"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
