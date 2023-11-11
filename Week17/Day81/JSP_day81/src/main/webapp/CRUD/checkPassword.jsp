<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
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


<%! 
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/CRUDPrac?serverTimezone=UCT";
static final String DB_USER = "root";
static final String DB_PASSWOARD = "0000";
static final String TABLE = "boards";

static private boolean checkPassword(Connection conn, int id, String password) throws SQLException{
	if(password == "") return false;
	Statement stmt = conn.createStatement();
	String correctPassword = null;
	ResultSet rs = stmt.executeQuery("select password from " + TABLE + " where id = "+id);
	if(rs.next()){
		correctPassword = rs.getString("password"); 
	} 
	else{
		return false;
	}
	if(password.equals(correctPassword)) return true;
	return false;
}

static private String modify(Connection conn, int id) throws SQLException{
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select title, content from" + TABLE + " where id = "+id);
	if(rs.next()){
		StringBuilder pageStr = new StringBuilder(100);
		pageStr.append("<form>");
		pageStr.append("<textarea>"+rs.getString("title")+"</textarea>");
		pageStr.append("<textarea>"+rs.getString("content")+"</textarea>");
		pageStr.append("</form>");
		
		return pageStr.toString();
	}
	return null;
}

static private void delete(Connection conn, int id)throws SQLException{
	Statement stmt = conn.createStatement();
	stmt.executeUpdate("delete from "+TABLE+" where id = "+id);
}
%>



<%
	String method = request.getParameter("method");
	int id = Integer.parseInt(request.getParameter("id"));
	String password = request.getParameter("password");
	Class.forName("com.mysql.cj.jdbc.Driver");

	try (Connection conn = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWOARD)) {
		if(checkPassword(conn, id, password)){
			switch (method) {
			case "modify":
					String updatePageStr = modify(conn, id);
					out.print(updatePageStr);
					break;
				
			case "delete":
					delete(conn,id);
					response.sendRedirect("board.jsp");
					break;
			}
		}
		
	} catch (SQLException e){
		e.printStackTrace();
	}
	switch(method) {
		
	}

%>