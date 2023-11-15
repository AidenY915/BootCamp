<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)(session.getAttribute("id"));
	if(id != null) {
		out.print(id + " 환영합니다.");
		session.setMaxInactiveInterval(3);
	}else{
%>
	<form method = "post" action = "login.jsp">
		<input type = 'text' name = 'id'>
		<input type = 'password' name = 'pw'>
		<button>Log In</button>
	</form>
	<%} %>
</body>
</html>