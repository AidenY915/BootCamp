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
<form method = "post" action = "RegisterOK.do">
	<table>
		<tr><td>ID</td><td><input type = 'text' name = 'id'><button>중복 확인</button></td></tr>
		<tr><td>비밀번호</td><td><input type = 'password' name = 'password'></td></tr>
		<tr><td>비밀번호 확인</td><td><input type = 'password' name = 'passwordCheck'></td></tr>
	</table>
</form>
</body>
</html>