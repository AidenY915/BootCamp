<%@page import="java.sql.ResultSet"%>
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
<style>
		form {
			border: 1px solid #555;
			width: 400px;
		}

		form>* {
			border: 1px solid #555;
		}

		textarea {
			min-height: 300px;
			width: 350px;
		}
	</style>
</head>
<body>
	<%!private static final String DB = "CRUDprac1";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String TABLE = "board";
	private static final String selectQuery = "SELECT writer, email, createdDate, title, content, views FROM " + TABLE + " WHERE no = ?";
	%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");
	try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
		PreparedStatement pStmt = conn.prepareStatement(selectQuery);
		pStmt.setInt(1, no);
		ResultSet rs = pStmt.executeQuery();
		if(rs.next()) {
			String writer = rs.getString("writer");
			String email= rs.getString("email");
			String createdDate = rs.getString("createdDate");
			String title = rs.getString("title");
			String content = rs.getString("content");
			int views  = rs.getInt("views");
			%>

	<form method = 'post' action = 'updateBoard.jsp'>
		<div>
			<span>작성자: <%=writer%></span>
		</div>
		<div>
			<span>email: <%=email%></span>
		</div>
		<div>
			<span>제목: <%=title%></span>
		</div>
		<div>
			<div>내용:</div>
			<div><textarea name = 'content'><%=content%></textarea></div>
		</div>
		<input type="hidden" name="no" value=<%= no %> />
		<input type="hidden" name="method" value="update" />
		<input type="hidden" name="password" value=<%= password %>>
		<button>수정</button>
	</form>
	<%
		}
		else response.sendRedirect("error.jsp");
	}
	%>
</body>
</html>