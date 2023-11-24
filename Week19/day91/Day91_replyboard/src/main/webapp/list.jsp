<%@page import="daodto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%List<BoardDto> boards = (List<BoardDto>)request.getAttribute("boards"); %>
	
	<table border = '1'>
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
		<% for(BoardDto board : boards) {
			String indent = "";
			for(int i = 0; i < board.getIndentNum(); i++)
				indent+="&nbsp;&nbsp;";
			if(board.getIndentNum()>0)
				indent+="└ ";
			out.write("<tr class = 'boardTr' id = '" + board.getNo() + "'>");
			out.write("<td>" + board.getNo() + "</td>");
			out.write("<td>" + indent + board.getTitle() + "</td>");
			out.write("<td>" + board.getWriter() + "</td>");
			out.write("<td>" + board.getCreatedDate() + "</td>");
			out.write("<td>" + board.getViews() + "</td>");
			out.write("</tr>");
		}%>
	</table>
	<a href = "newboard.do"><button>글 작성</button></a>
	<script>document.querySelectorAll(".boardTr").forEach(function(e) {
		e.addEventListener("click", function () {
			location.assign("boardView.do?no="+this.id);
		})
	})</script>
</body>
</html>