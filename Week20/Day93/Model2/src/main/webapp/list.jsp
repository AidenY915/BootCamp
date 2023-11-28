<%@page import="com.superman.ex.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>목록</title>
</head>
<body>

<table border="1">
	<tr>
		<td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>조회수</td>
	</tr>
	<c:forEach var = 'dto' items = '${list}'>
		<tr>
		<td>${dto.num}</td>
		<td>${dto.name}</td>
		<td>
			<c:forEach begin = '1' end = '${dto.indentNum}'>
				-
			</c:forEach>
			<a href="view.do?num=${dto.num}">${dto.title}</a>
		</td>
		<td>${dto.wtime}</td>
		<td>${dto.hit}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>
</body>
</html>