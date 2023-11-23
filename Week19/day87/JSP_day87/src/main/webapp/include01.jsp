<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	include01
	<%= pageContext %>
	<br>
	<jsp:include page = "include02.jsp"/>
	<br>
	include01
	<%= pageContext %>
</body>
</html>