<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action="LoginOK.do">
		<table>
			<tr>
				<td>ID</td>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='password'></td>
			</tr>
		</table>
		<button>Log in</button>
		<a href="register.do"><button type='button'>회원가입</button></a>
	</form>
</body>
</html>