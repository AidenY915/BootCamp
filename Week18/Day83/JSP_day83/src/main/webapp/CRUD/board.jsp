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
	<%@ include file="databaseInfo.jsp"%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	String selectQuery = "SELECT no, title, writer, createdDate, views FROM " + TABLE + " ORDER BY no DESC";
	String rowsQuery = "SELECT count(*) 'rows' FROM " + TABLE;
	try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		Statement stmt = conn.createStatement();
	%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
		ResultSet rs = stmt.executeQuery(selectQuery);
		while (rs.next()) {
		%>
		<tr class="boardTr" data-no="<%=rs.getInt("no")%>">
			<td><%=rs.getInt("no")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getString("writer")%></td>
			<td><%=rs.getTimestamp("createdDate")%></td>
			<td><%=rs.getInt("views")%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	rs = stmt.executeQuery(rowsQuery);
	if (rs.next()) {
		out.write("<div>행수 : " + rs.getInt("rows") + "</div>");
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>
	<script>
			document.querySelectorAll(".boardTr").forEach(e => {
				e.addEventListener('click', function() {
					location.assign("boardDetail.jsp?no="+this.dataset.no);
				});
			});
		</script>
	<a href="newboard.html"><button>새 글</button></a>
</body>
</html>
