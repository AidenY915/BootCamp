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
	<table border = '1'>
		<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
			<% for(BoardDto board : boards) {
				String indent = "&nbsp;";
				for(int i = 0 ; i < board.getIndentNum() - 1; i++){ 
					indent += "&nbsp;&nbsp;&nbsp;";
				}
				if(board.getIndentNum()>=1) indent += "└ ";
				out.print("<tr id = "  + board.getNo() + ">"
				+"<td>" + board.getNo() + "</td>"
				+"<td width = '200px'>" + indent + board.getTitle() + "</td>"
				+"<td>" + board.getWriter() + "</td>"
				+"<td>" + board.getCreatedDate() + "</td>"
				+"<td><button class = 'deleteBtn' type = 'button'>X</button></td>"
				+"</tr>");				
			}	%>
	</table>
	<a href = "newboard.html"><button type = 'button'>글쓰기</button></a>
	<script>
		document.querySelectorAll("td:not(:last-child)").forEach((e) => {
			e.addEventListener("click", function () {
			location.assign("boardDetail.do?no=" + this.parentNode.id);
			});
		});
		document.querySelectorAll(".deleteBtn").forEach((e) => {
			e.addEventListener("click", function() {
				location.assign("password.do?no="+this.parentNode.parentNode.id+"&nextPage=Delete.do");			
				})
		})
	</script>
</body>
</html>