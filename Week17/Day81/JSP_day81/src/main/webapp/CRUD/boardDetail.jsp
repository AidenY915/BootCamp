<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
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

</body>
</html>

<%! 
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUDPrac?serverTimezone=UCT";
static final String DB_USER = "root";
static final String DB_PASSWOARD = "0000";
static final String TABLE = "boards";

static final String detailString(Connection conn, HttpServletRequest request) throws SQLException{
	int id = Integer.parseInt(request.getParameter("id"));
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select id, title, content, createdDate from "+ TABLE +" where id = "+ id);
	if(rs.next()){
		String title = rs.getString("title");
		String content = rs.getString("content");
		String createdDate = rs.getTimestamp("createdDate").toString();
		
		StringBuilder detailStr = new StringBuilder(300);
		detailStr.append("<div>");
		detailStr.append("<div><span>제목<span>" + content + "</div>");
		detailStr.append("<div><span>작성일<span>" + createdDate + "</div>");
		detailStr.append("<div><div>내용<div>" + content + "</div>");
		detailStr.append("</div>");
		
		detailStr.append("<input name = 'id' type = 'hidden' value = '"+id+"'>");
		detailStr.append("<form method ='post' action = 'checkPassword.jsp'>");
		detailStr.append("<input type = 'hidden' name = 'id' value = '"+id+"'>");
		detailStr.append("<button><input type = 'radio' name = 'method' value = 'modify'>수정</button>");
		detailStr.append("<button><input type = 'radio' name = 'method' value = 'delete'>삭제</button>");
		detailStr.append("<span>비밀번호<span><input type = 'password' name = 'password' >");
		detailStr.append("</form>");
		
		return detailStr.toString();
		
	}
	else {
		return null;
	}
	
	
	
}
%>

<% 
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection conn = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWOARD)) {
	request.setCharacterEncoding("UTF-8");
	String detailStr = detailString(conn, request);
	if(detailStr == null) response.sendRedirect("board.jsp");
	else {
		out.print(detailStr);
	}
	
} catch (SQLException e){
	e.printStackTrace();
}
%>    