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
.frame {
	border : 1px solid #555;
	width : 400px;
}
.frame > * {
	border : 1px solid #555;
}
.content{
 	min-height:300px;
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
	private static final String updateViewQuery = "UPDATE " + TABLE + " SET views = ? WHERE no = ?";
	
%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	int no = Integer.parseInt(request.getParameter("no"));
	try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
		PreparedStatement pStmt = conn.prepareStatement(selectQuery);
		pStmt.setInt(1, no);
		ResultSet rs = pStmt.executeQuery();
		if(rs.next()) {
			String writer = rs.getString("writer");
			String email= rs.getString("email");
			String createdDate = rs.getTimestamp("createdDate").toString();
			String title = rs.getString("title");
			String content = rs.getString("content");
			int views = rs.getInt("views");
			views++;
			PreparedStatement updateViewStmt = conn.prepareStatement(updateViewQuery);
			updateViewStmt.setInt(1,views);
			updateViewStmt.setInt(2,no);
			updateViewStmt.executeUpdate();
			
			%>

	<div class = 'frame'>
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
			<div class = 'content'><%=title%></div>
		</div>
		<div>
			<span>작성일: <%=createdDate%></span>&nbsp;<span>조회수: <%=views%></span>
		</div>
	</div>
	<form action = "boardPassword.jsp" style = "display:inline-block">
		<input type="hidden" name="no" value=<%= no %> />
		<input type="hidden" name="method" value="update" />
		<button>수정</button>
	</form>
	<form action = "boardPassword.jsp" style = "display:inline-block">
		<input type="hidden" name="no" value=<%= no %> />
		<input type="hidden" name="method" value="delete" />
		<button>삭제</button>
	</form>
	<a href="board.jsp"><button>목록</button></a>
	<%
		}
		else response.sendRedirect("error.jsp");
	}
	%>
</body>
</html>