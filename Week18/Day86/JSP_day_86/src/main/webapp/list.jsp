<%@page import="java.util.List"%>
<%@page import="com.daodto.www.BoardDTO"%>
<%@page import="com.daodto.www.BoardDAO"%>
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
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
		BoardDAO boardDAO = BoardDAO.getBoardDAO();
		List<BoardDTO> boards = boardDAO.getBoards(); 
		if (boards != null) {
			for (BoardDTO board : boards) {
		%>
		<tr>
			<td><%=board.getNo()%></td>
			<td><%=board.getTitle()%></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getCreatedDate()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
</body>
</html>