<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> names = request.getParameterNames();
	while(names.hasMoreElements()){
		String name = names.nextElement();
		out.write("<br>name : "+name);
		out.write("<br>value : "+request.getParameter(name));
	}
%>
</body>
</html>