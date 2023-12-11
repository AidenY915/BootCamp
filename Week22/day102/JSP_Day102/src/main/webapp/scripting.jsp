<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
>
</head>
<body>
	<%!private String toLowerCase(String str) {
		return str.toLowerCase();
	}
	private String str1 = "Welcome to Web Shopping Mall";
	private String str2 = "Welcome to Web Market!";%>
	<c:set var='count' value='3' />
	<c:forEach begin='1' end='${count}' varStatus='status'>
		Java Server Pages ${status.index}.<br>
	</c:forEach>
	<%=toLowerCase("Hello World")%>

	<nav class='navbar bg-dark navbar-dark'>
		<ul class='navbar-nav'>
			<li class='nav-item'><a class = 'nav-link' href = '#'>HOME</a></li>
		</ul>
	</nav>
	<div class='jumbotron jumbotron-fluid d-flex justify-content-center display-1 text-center'>
		<p class ='fs-1'>
		<%=str1%>
		</p>
	</div>
	<div class='container d-flex justify-content-center'>
		<%=str2%>
	</div>
	<footer></footer>
	<%   pageContext.forward("error.jsp"); %>
	
</body>
</html>