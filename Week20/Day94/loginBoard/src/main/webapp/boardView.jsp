<%@page import="com.loginboard.www.daodto.BoardDto"%>
<%@page import="com.loginboard.www.daodto.MemberDto"%>
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
<style>
	form{
		display:inline-block;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>닉네임</td>
			<td>${member.nickname}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>
	</table>
	<c:url var="answer" value="newboard.do">
		<c:param name="groupNum" value="${board.groupNum}" />
		<c:param name="stepNum" value="${board.stepNum}" />
		<c:param name="indentNum" value="${board.indentNum}" />
	</c:url>
	<a href='${answer}'><button>답변</button></a>
	<a href='list.do'><button type='button'>목록</button></a>
	<c:if test="${member.id eq sessionScope.id}">
		<form>
			<input type="hidden" name='id' value="${member.id}"> <input
				type="hidden" name='no' value="${board.no}"
			>
			<button>수정</button>
		</form>
		<form method='post' action='DeleteOK.do'>
			<input type="hidden" name='id' value="${member.id}"> <input
				type="hidden" name='no' value="${board.no}"
			>
			<button>삭제</button>
		</form>
	</c:if>
</body>
</html>