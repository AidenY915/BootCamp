<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id = 'student' class = "com.superman.ex.StudentBean" scope = "page"/>
	<jsp:setProperty name = 'student' property = 'name' value = "홍길동" />
	<jsp:setProperty name = 'student' property = 'age' value = "10" />
	<jsp:setProperty name = 'student' property = 'grade' value = "3" />
	<jsp:setProperty name = 'student' property = 'studentNum' value = "28" />
	
	<jsp:getProperty name = 'student' property = 'name' />
	<jsp:getProperty name = 'student' property = 'age' />
	<jsp:getProperty name = 'student' property = 'grade' />
	<jsp:getProperty name = 'student' property = 'studentNum' />
</body>
</html>