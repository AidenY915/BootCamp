<%@page import="com.write.www.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.write.www.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BoardDAO dao = BoardDAO.getBoardDAO();
	List<BoardDTO> boards = dao.getBoards();
	for(BoardDTO board : boards){
		out.write("<p>" + board.getId() + "</p>");
		out.write("<p>" + board.getWriter() + "</p>");
		out.write("<p>" + board.getTitle() + "</p>");
		out.write("<p>" + board.getContent() + "</p>");
		out.write("<p>" + board.getCreatedDate().toString() + "</p>");
	}%>
</body>
</html>