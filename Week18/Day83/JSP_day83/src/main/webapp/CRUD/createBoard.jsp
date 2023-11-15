<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="databaseInfo.jsp"%>
	<%
String insertQuery ="INSERT INTO " + TABLE + " (title, content, writer, email, password) VALUES(?, ?, ?, ?, ?)";
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");
String email = request.getParameter("email");
String password = request.getParameter("password");
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
	PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
	insertStmt.setString(1,title);
	insertStmt.setString(2,content);
	insertStmt.setString(3,writer);
	insertStmt.setString(4,email);
	insertStmt.setString(5,password);
	insertStmt.executeUpdate();
	response.sendRedirect("board.jsp");
}catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>