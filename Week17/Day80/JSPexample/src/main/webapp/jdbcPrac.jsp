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
</head>
<body>
</body>
</html>

<%
Class.forName("com.mysql.jdbc.Driver");
String databaseUrl = "jdbc:mysql://localhost:3306/jdbcPracDB?serverTimezone=UCT";
String DBUser = "root";
String DBPassword = "0000";

request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
PreparedStatement insertPstmt = null;

try (Connection conn = DriverManager.getConnection(databaseUrl, DBUser, DBPassword)) {
	insertPstmt = conn.prepareStatement("insert into USERS(ID, PW) values(?,?)");
	insertPstmt.setString(1, id);
	insertPstmt.setString(2, pw);
	insertPstmt.executeUpdate();
	
	try(ResultSet rs = insertPstmt.executeQuery("select * from USERS")) {
		while(rs.next()){
			out.print(rs.getString(1));
			out.print(rs.getString(2) + "<br>");
		}
	}catch (Exception e){
		e.printStackTrace();
		out.print("resultSet ERROR");
	}
}catch (Exception e){
	e.printStackTrace();
}
finally {
	if(insertPstmt!=null)
		insertPstmt.close();
}
%>