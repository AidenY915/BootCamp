<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%! private String str = "Hello. Java Server Pages";
		public String getString() {return str;}%>
		<%= getString() %>
		<br>
		<% Date date = new Date(); %>
		<%= date %>
		<br>
		<% Calendar calendar = Calendar.getInstance(); %>
		<%= calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.DATE) %>
		
</body>
</html>