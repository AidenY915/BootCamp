<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id= request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String hobby = request.getParameter("hobby");
	String major = request.getParameter("major");
	String telecom = request.getParameter("telecom");
	int age = Integer.parseInt(request.getParameter("age"));
%>

<%=
	"이름: "+name+"</br>"+
	"아이디: "+id+"</br>"+
	"비밀번호: "+password+"</br>"+
	"이메일: "+email+"</br>"+
	"취미: "+hobby+"</br>"+
	"전공: "+major+"</br>"+
	"통신사: "+telecom+"</br>"
%>

<%
if(age >= 20) {
	out.write("술 살 수 있음");	
}
else {
	out.write("술 살 수 없음");
}
%>