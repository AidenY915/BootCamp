<%@page import="com.replyboard.www.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
		BoardDto board = (BoardDto) request.getAttribute("board");
		%>
		<tr>
			<td>작성자</td>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<td colspan = 2><textarea cols = '20' rows = '30'><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan = 2>작성일 : <%= board.getCreatedDate().toString() %></td>
		</tr>
	</table>
	<a href = "newAnswer.do?groupNum=<%=board.getGroupNum()%>&stepNum=<%=board.getStepNum()%>&indentNum=<%=board.getIndentNum()%>"><button type = 'button'>답변</button></a>
</body>
</html>