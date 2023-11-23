<%@page import="ch04.com.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "person" class = "ch04.com.dto.Person" scope = "request" />
 <%= person.getId() %>
 <%= person.getName() %>
 
 <%= ((Person)(request.getAttribute("person"))).getId() %>
 <%= ((Person)(request.getAttribute("person"))).getName() %>
 
 <jsp:setProperty name = "person"  property= "id" param = "11111"/>
 <jsp:setProperty name = "person" property= "name" value = "윤"/>
 <jsp:getProperty name = "person" property= "id" />
 <jsp:getProperty name = "person" property= "name" />
 
  <%= ((Person)(request.getAttribute("person"))).getId() %>
 <%= ((Person)(request.getAttribute("person"))).getName() %>

</body>
</html>