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
	<c:if test = "${sessionScope.id eq null}">
		<%@include file = "login.jsp"%>
		<div>아이디와 비밀번호가 일치하지 않습니다.</div>
	</c:if>
	<c:if test = "${sessionScope.id ne null}">
		${id}님 환영합니다.
		<div><a href = "LogoutOK.do"><button>로그아웃</button></a><a href = "list.do"><button>게시판</button></a><a href = "updatememberinfo.do"><button>회원정보수정</button></a></div>
	</c:if>
</body>
</html>