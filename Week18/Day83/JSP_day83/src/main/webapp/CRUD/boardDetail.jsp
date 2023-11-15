<%@page import="java.sql.PreparedStatement"%>
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
<style>
form {
	display: inline-block
}
</style>
</head>
<body>
	<%@ include file = "databaseInfo.jsp" %>
	<%
	int no = Integer.parseInt(request.getParameter("no"));
	Class.forName("com.mysql.cj.jdbc.Driver");
	String selectQuery = "SELECT no, title, content, writer, email, createdDate, views FROM " + TABLE + " WHERE no = " + no;
	String updateViewQuery = "UPDATE " + TABLE + " SET views = views+1, createdDate = createdDate WHERE no = " + no;
	try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String email = rs.getString("email");
			String content = rs.getString("content");
			String createdDate = rs.getTimestamp("createdDate").toString();
			stmt.executeUpdate(updateViewQuery);
	%>
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
			<td>작성일</td>
			<td><%=createdDate%></td>
		</tr>
		<tr>
			<td colspan=2><%=content%></td>
		</tr>
		<tr>
			<td colspan=2>
				<form action = "inputPassword.jsp">
					<input type='hidden' name='no' value=<%= no %>> <input
						type="hidden" name="mode" value="modify"
					>
					<button>수정</button>
				</form>
				<form action = "inputPassword.jsp">
					<input type='hidden' name='no' value=<%= no %>> <input
						type="hidden" name="mode" value="delete"
					>
					<button>삭제</button>
				</form> <a href="board.jsp"><button type="button">목록</button></a>
			</td>
		</tr>
	</table>

	<%
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>
</body>
</html>