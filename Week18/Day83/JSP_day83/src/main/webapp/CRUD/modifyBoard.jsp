<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<%@ include file = "databaseInfo.jsp" %>

	<%
	String no = request.getParameter("no");
	String password = request.getParameter("password");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String selectQuery = "SELECT title, writer, email, content FROM " + TABLE + " WHERE no = " + no;
	try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String email = rs.getString("email");
			String content = rs.getString("content");
	%>
	<form action="updateBoard.jsp">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><%=title%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=writer%></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><%=email%></td>
			</tr>
			<tr>
				<td colspan=2><textarea cols="30" rows="20" name='content'><%=content%></textarea></td>
			</tr>
			<tr>
				<td colspan=2></td>
			</tr>
		</table>
		<input type='hidden' name='no' value=<%=no%>> <input
			type='hidden' name='password' value=<%=password%>
		>
		<button>수정</button>
	</form>
	<a href="board.jsp"><button type="button">목록</button></a>

	<%
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>
</body>
</html>