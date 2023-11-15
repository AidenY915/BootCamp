<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
	<%@ include file = "databaseInfo.jsp" %>

	<%
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String updateQuery = "UPDATE " + TABLE + " SET content = '" + content + "' WHERE no = " + no;
		String passwordQuery = "SELECT password FROM " + TABLE + " WHERE no = " + no;
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(passwordQuery);
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					stmt.executeUpdate(updateQuery);
					response.sendRedirect("board.jsp");
				}else{
					%>
					<script>
					alert("잘못된 비밀번호입니다.");
					location.assign("board.jsp");
					</script>
					<%
				}
			}else response.sendRedirect("board.jsp");
		}catch(SQLException e){
			e.printStackTrace();
		}
		%>
</body>
</html>