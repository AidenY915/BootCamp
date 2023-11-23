<%@page import="com.replyboard.www.BoardDto"%>
<%@page import="java.util.List"%>
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
	<% List<BoardDto> boards = (List<BoardDto>)request.getAttribute("boards");%>
	<table>
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
			<% for(BoardDto board : boards) {
				String indent = "";
				for(int i = 0 ; i < board.getIndentNum(); i++){ 
					indent += "-";
				}
				out.print("<tr id = "  + board.getNo() + ">"
				+"<td>" + board.getNo() + "</td>"
				+"<td>" + indent + board.getTitle() + "</td>"
				+"<td>" + board.getWriter() + "</td>"
				+"<td>" + board.getCreatedDate() + "</td>"
				+"</tr>");				
			}	%>
	</table>
	<a href = "newboard.html"><button type = 'button'>글쓰기</button></a>
	<script>
		document.querySelectorAll("tr:not(:first-child)").forEach((e) => {
			e.addEventListener("click", function () {
			location.assign("boardDetail.do?no=" + this.id);
			});
		});
	</script>
</body>
</html>