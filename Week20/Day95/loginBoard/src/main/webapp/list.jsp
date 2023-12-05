<%@page import="com.loginboard.www.daodto.BoardDto"%>
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
	<form action = "list.do">
		<select name = 'searchMode'>
		<option value = "t&c" ${ parm.searchMode != null && parm.searchMode == "t&c" ? "selected" : "" }>제목+내용</option>
		<option value = "w" ${ parm.searchMode != null && parm.searchMode == "w" ? "selected" : "" }>작성자</option>
		</select>
		<input type = 'search' name = search>
		<button>검색</button>
	</form>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var='board' items='${requestScope.boards}'>
			<tr onclick='location.assign("boardview.do?no=${board.no}");'>
				<td>${board.no}</td>
				<td>${board.nickname}</td>
				<td>${board.title}</td>
				<td>${board.createdDate}</td>
				<td>${board.views}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:forEach var='number' begin="${start}"
			end="${end}"
		>
			<a href="list.do?searchMode=${param.searchMode}&search=${param.search}&page=${number}"><button>${number}</button></a>
		</c:forEach>
	</div>
	<a href="newboard.do"><button>글쓰기</button></a>
	<a href="loginafter.do"><button>마이페이지</button></a>
</body>
</html>