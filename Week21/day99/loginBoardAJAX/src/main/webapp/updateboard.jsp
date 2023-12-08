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
	<form method="post" action="UpdateBoardOK.do">
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
				<td><input type='text' name='title' value='${board.title}'></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name='content' rows = '30'>${board.content}</textarea></td>
			</tr>
		</table>
		<input type='hidden' name = 'no' value='${param.no}'>
		<button>수정</button>
	</form>
</body>
</html>