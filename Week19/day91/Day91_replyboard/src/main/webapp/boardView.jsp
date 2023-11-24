<%@page import="daodto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form{
display:inline-block;
}
</style>
</head>
<body>
	<%
	BoardDto board = (BoardDto) request.getAttribute("board");
	%>
	<table border = '1'>
		<tr>
			<td>작성자</td>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<td colspan=2><%=board.getContent()%></td>
		</tr>
		<tr>
			<td colspan=2>작성일 : <%=board.getCreatedDate()%></td>
		</tr>
	</table>
	<form method="post" action="newboard.do">
		<input type="hidden" name="groupNum"
			value='<%=board.getGroupNum()%>'
		> <input type="hidden" name="stepNum"
			value='<%=board.getStepNum()%>'
		> <input type="hidden" name="indentNum"
			value='<%=board.getIndentNum()%>'
		><input type="hidden" name="parentNum"
			value='<%=board.getNo()%>'
		>
		<button>답변</button>
	</form>
	<a href = "list.do"><button>목록</button></a>
	<form method = "post" action = "DeleteOK.do">
		<input type = "hidden" name = 'no' value='<%= board.getNo() %>'>
		<button class = 'deleteBtn'>삭제</button>
	</form>
</body>
</html>