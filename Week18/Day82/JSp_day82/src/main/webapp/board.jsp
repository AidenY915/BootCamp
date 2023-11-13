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
	<%!private static final String DB = "CRUDprac1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String TABLE = "board";
	private static final String selectQuery = "SELECT no, title, writer, createdDate FROM " + TABLE + " ORDER BY no DESC";%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	%>
	<table border = '1'>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String createdDate = rs.getTimestamp("createdDate").toString();
		%>
		<tr id = '<%=no%>'>
			<td><%=no%></td>
			<td><%=title%></td>
			<td><%=writer%></td>
			<td><%=createdDate%></td>
		</tr>
		<script>
		document.addEventListener('DOMContentLoaded', () => {
			document.getElementById('<%=no%>').addEventListener('click', () => {
				location.assign("/JSP_day82/boardDetail.jsp?no=<%=no%>");
			});
		});
		</script>
		<%
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		%>
	</table>
	<a href = "newboard.html"><button>글 쓰기</button></a>
</body>
</html>
