<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	<%!
	private static final String DB = "CRUDprac1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String TABLE = "board";
	private static final String deleteQuery = "DELETE FROM " + TABLE + " WHERE no = ?";
	private static final String passwordQuery = "SELECT password FROM " + TABLE + " WHERE no = ?";
	%>

	<%
	int no = Integer.parseInt(request.getParameter("no")); 
	String password = request.getParameter("password"); 
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
		PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
		PreparedStatement passwordStmt = conn.prepareStatement(passwordQuery);
		deleteStmt.setInt(1, no);
		passwordStmt.setInt(1,no);
		ResultSet rs = passwordStmt.executeQuery();
		int rslt = 0;
		if(rs.next()){
			String correctPassword = rs.getString("password");
			if(correctPassword.equals(password)){
				rslt = deleteStmt.executeUpdate(); 
				if(rslt > 0){
					response.sendRedirect("board.jsp");
				}
			}
		}
		if(rslt == 0){
			response.sendRedirect("error.jsp");
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	%>


</body>
</html>