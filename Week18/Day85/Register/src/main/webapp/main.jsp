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
	if(id == null) {
		%>
			<form method = "post" action = "LoginOK">
			<div>아이디: <input type = 'text' name = 'id'></div>
			<div>비밀번호: <input type = 'password' name = 'pw'></div>
			<button>Log in</button><a href = "memberRegister.html"><button type='button'>회원가입</button></a>
			</form>
		<%
	}else {
		session.setAttribute("id", id);
		%>
		<p><%= id %>님 환영합니다.</p>
		<div><a href = "Logout">로그아웃</a>&nbsp;<a href = "memberModify.jsp">개인정보수정</a></div>
		<%
	}
%>
</body>
</html>