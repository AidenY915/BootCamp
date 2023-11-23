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
	<table border = '1'>
		<%
		BoardDto board = (BoardDto) request.getAttribute("board");
		%>
		<tr>
			<td width = "30%">작성자</td>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<td width = "30%">제목</td>
			<td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<td colspan = 2 height = '480px'><%=board.getContent()%></td>
		</tr>
		<tr>
			<td colspan = 2>작성일 : <%= board.getCreatedDate().toString() %></td>
		</tr>
	</table>
	<a href = "newAnswer.do?groupNum=<%=board.getGroupNum()%>&stepNum=<%=board.getStepNum()%>&indentNum=<%=board.getIndentNum()%>"><button type = 'button'>답변</button></a>
	<a href = "password.do?no=<%=board.getNo()%>&nextPage=modify.do"><button>수정</button></a>
</body>
</html>