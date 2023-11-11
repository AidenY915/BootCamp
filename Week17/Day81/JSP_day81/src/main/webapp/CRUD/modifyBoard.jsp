<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<%-- 여기는 데이터 베이스에 직접 접근하는 API 따라서 여기서 Authorization이 있어야 함. 이전 페이지에서 확인한 뒤 수정 API로 보낸 뒤, 검증 없이 수정하는 방식으로 설계하면, 서버 외부에서 수정 페이지로 바로 접근 시 데이터를 보호할 수 없음. --%>
<%! 
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUDPrac?serverTimezone=UCT";
static final String DB_USER = "root";
static final String DB_PASSWOARD = "0000";
static final String TABLE = "boards";

static private boolean checkPassword(Connection conn, int id, String password) throws SQLException{
	Statement stmt = conn.createStatement();
	String correctPassword = null;
	ResultSet rs = stmt.executeQuery("select password from " + TABLE + " where id = "+id);
	if(rs.next()){
		correctPassword = rs.getString("password"); 
	} 
	else{
		return false;
	}
	if(password.equals(correctPassword)) return true;
	return false;
}

static final void updateBoard(Connection conn, int id , String title, String content) throws SQLException {
	Statement stmt = conn.createStatement();
	String queryStr = "update " + TABLE + " set title = '" + title + "', content = '" + content + "' where id = " + id;
	stmt.executeUpdate(queryStr);
}
%>

<% 
int id = Integer.parseInt(request.getParameter("id"));
String title = request.getParameter("title");
String content = request.getParameter("content");
String password = request.getParameter("password");
Class.forName("com.mysql.cj.jdbc.Driver");

System.out.println(id);
System.out.println(title);
System.out.println(content);

try(Connection conn = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWOARD)){
	if(checkPassword(conn, id, password)){
		updateBoard(conn, id, title, content);
	} else {
		out.print("비정상적인 접근입니다.");
	}
	response.sendRedirect("board.jsp");
}catch(SQLException e) {
	e.printStackTrace();	
}

%>
