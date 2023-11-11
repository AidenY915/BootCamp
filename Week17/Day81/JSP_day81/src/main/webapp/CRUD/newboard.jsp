<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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

<%! 
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUDPrac?serverTimezone=UCT";
static final String DB_USER = "root";
static final String DB_PASSWOARD = "0000";
static final String TABLE = "boards";

static final void createBoard(Connection conn ,HttpServletRequest request) throws SQLException {
	String title = request.getParameter("title");
	String content = request.getParameter("content");	
	String password = request.getParameter("password");
	
	PreparedStatement pStmt = conn.prepareStatement("INSERT INTO " + TABLE+"(title, content, password)" + " VALUES(?,?,?)");
	pStmt.setString(1, title);
	pStmt.setString(2, content);
	pStmt.setString(3, password);
	
	pStmt.executeUpdate();
}
%>

<% 
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection conn = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWOARD)) {
	request.setCharacterEncoding("UTF-8");
	
	createBoard(conn, request);
	response.sendRedirect("board.jsp");
		
	
} catch (SQLException e){
	e.printStackTrace();
}
%>    