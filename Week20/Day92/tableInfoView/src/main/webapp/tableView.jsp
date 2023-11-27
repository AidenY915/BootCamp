<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
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
	<%
	if (request.getMethod().equalsIgnoreCase("get")) {
	%>
	<form method="post">
		<table>
			<tr>
				<td>테이블명</td>
				<td><input type='text' name='tableName'></td>
			</tr>
			<tr>
				<td>조건절</td>
				<td><input type='text' name='tableWhere'></td>
			</tr>
		</table>
		<button>테이블 정보 획득</button>
	</form>
	<%
	} else if (request.getMethod().equalsIgnoreCase("post")) {
	String tableName = request.getParameter("tableName").trim();
	String tableWhere = request.getParameter("tableWhere").trim();
	if (tableName.equals("")) {
		response.sendRedirect(request.getRequestURI());
	} else {
		String selectQuery = "SELECT * FROM " + tableName + " " + tableWhere;
		System.out.println(selectQuery);
		final String JDNI_NAME = "jdbc/replyboard";
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:comp/env/" + JDNI_NAME);

		try (Connection conn = ds.getConnection()) {
			PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
			try (ResultSet rs = selectStmt.executeQuery()) {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCnt = rsmd.getColumnCount();
		System.out.println(columnCnt);
		out.write("<table board = '1'><tr>");
		for (int i = 1; i <= columnCnt; i++) {
			out.write("<th>" + rsmd.getColumnName(i) + "</th>");
		}
		out.write("</tr>");
		while (rs.next()) {
			out.write("<tr>");
			for (int i = 1; i <= columnCnt; i++) {
				String data = null;
				if (rsmd.getColumnTypeName(i).equalsIgnoreCase("int"))
					data = String.valueOf(rs.getInt(i));
				else if (rsmd.getColumnTypeName(i).equalsIgnoreCase("timeStamp"))
					data = rs.getTimestamp(i).toString();
				else
					data = rs.getString(i);
				out.write("<td>" + data + "</td>");
			}
			out.write("</tr>");
		}
		out.write("</table>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	%>
</body>
</html>