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
		String id = (String)session.getAttribute("id");
		if(id == null){
			%>
			<form method = "post" action = "LoginOK">
				<table>
				<tr><td>ID: </td><td><input type = 'text' name = "id"></td></tr>
				<tr><td>비밀번호: </td><td><input type = 'password' name = "pw"></td></tr>
				</table>
				<button>로그인</button><a href = "memberRegister.html"><button type="button">회원가입</button></a>
			</form>
			<%
		}else {
			%>
			<p><%= id %>님 환영합니다.</p>
			<a href = "Logout">로그아웃</a>&nbsp;<a>개인정보변경</a>
			<%
		}
	%>
</body>
</html>