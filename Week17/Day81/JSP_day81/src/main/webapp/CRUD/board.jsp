<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<%! 
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUDPrac?serverTimezone=UCT";
static final String DB_USER = "root";
static final String DB_PASSWOARD = "0000";
static final String TABLE = "boards";

static final String showBoards(Connection conn) throws SQLException{
	PreparedStatement pStmt = conn.prepareStatement("select id, title, createdDate from " + TABLE);
	ResultSet rs = pStmt.executeQuery();
	String writeButton = "<a href = 'createBoard.html'><button>글쓰기</button></a>";
	StringBuilder result = new StringBuilder(1000);
	result.append("<table border = '1'>");
	result.append("<tr><th>글번호</th><th>글제목</th><th>작성일</th></tr>");
	while(rs.next()){
		int id = rs.getInt("id");
		String title = rs.getString("title");
		Timestamp createdDate = rs.getTimestamp("createdDate");
		result.append("<tr class ='boardTr'><td>" + id + "</td>");
		result.append("<td><a href = 'boardDetail.jsp?id="+id+"'>" + title + "</a></td>");
		result.append("<td>" + createdDate.toString() + "</td></tr>");
	}
	result.append("</table>");
	result.append(writeButton);
	return result.toString();
}
%>


<% 
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection conn = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWOARD)) {
		request.setCharacterEncoding("UTF-8");
		out.print(showBoards(conn));
	
} catch (SQLException e){
	e.printStackTrace();
}
%>    

</body>
</html>

