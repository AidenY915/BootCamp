<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<%!private static final String DB = "CRUDprac1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String TABLE = "board";
	private static final String insertQuery = "INSERT " + TABLE + "(writer, email, title, content, password) values(?,?,?,?,?)";
	%>
	<%
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			pStmt.setString(1, writer);
			pStmt.setString(2, email);
			pStmt.setString(3, title);
			pStmt.setString(4, content);
			pStmt.setString(5, password);
			int rslt = pStmt.executeUpdate();
			if(rslt > 0) {
				ResultSet rs = pStmt.executeQuery("SELECT MAX(no) 'no' FROM " + TABLE);
				if(rs.next()){
					response.sendRedirect("boardDetail.jsp?no="+rs.getInt("no"));
				}
				else{
					response.sendRedirect("error.jsp");
				}
			}else {
				response.sendRedirect("error.jsp");
			}
		}
	%>
</body>
</html>