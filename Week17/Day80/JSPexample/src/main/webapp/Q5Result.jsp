<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String[] hobby = request.getParameterValues("hobby");
	String major = request.getParameter("major");
	String telecom = request.getParameter("telecom");
	%>

	<%="이름: " + name + "<br/>" + "아이디: " + id + "<br/>" + "비밀번호: " + pw + "<br/>" + "이메일: " + email + "<br/>"
		+ "취미: " + Arrays.toString(hobby) + "<br/>" + "전공: " + major + "<br/>" + "통신사: " + telecom%>
</body>
</html>