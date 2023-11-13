<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!private static final String DB = "CRUDprac1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String TABLE = "board";
	private static final String updateQuery = "UPDATE " + TABLE + " SET content = ?, createdDate = ? WHERE no = ?";
	private static final String passwordQuery = "SELECT password FROM " + TABLE + " WHERE no = ?";
	%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	Timestamp createdDate = new Timestamp(System.currentTimeMillis());
	try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
		PreparedStatement pStmt = conn.prepareStatement(updateQuery);
		pStmt.setString(1,content);
		pStmt.setTimestamp(2, createdDate);
		pStmt.setInt(3,no);
		
		PreparedStatement passwordStmt = conn.prepareStatement(passwordQuery);
		passwordStmt.setInt(1,no);
		ResultSet rs = passwordStmt.executeQuery();
		int rslt = 0;
		if(rs.next()){
			String correctPassword = rs.getString("password");
			if(correctPassword.equals(password)){
				rslt = pStmt.executeUpdate();
			}
		}
		if(rslt == 0) {
			response.sendRedirect("error.jsp");
		}
		else {
			response.sendRedirect("boardDetail.jsp?no=" + no);
		}
	}
	%>
</body>
</html>