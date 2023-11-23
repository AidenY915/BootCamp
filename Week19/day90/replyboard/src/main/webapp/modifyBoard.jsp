<%@page import="com.replyboard.www.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% BoardDto board = (BoardDto)request.getAttribute("board"); %>
	<form method="post" action="ModifyOK.do">
		<table border = '1'>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value='<%= board.getWriter() %>'></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value='<%= board.getTitle() %>'></td>
			</tr>
			<tr>
				<td colspan=2><textarea cols=20 rows=30 name = "content"><%= board.getContent() %></textarea></td>
			</tr>
		</table>
		<input type = "hidden" name = "no" value = '<%= request.getParameter("no") %>'>
		<input type = "hidden" name = "password" value = '<%= request.getParameter("password") %>'>
		<button>등록</button>
	</form>
</body>
</html>