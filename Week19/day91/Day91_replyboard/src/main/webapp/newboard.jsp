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
	<form method = "post" action = "WriteOK.do">
		<table border = '1'>
		<tr><td>작성자</td><td><input type = "text" name = "writer"></td></tr>
		<tr><td>제목</td><td><input type="text" name="title"></td></tr>
		<tr><td colspan = 2><textarea cols = 20 rows = 20 name = 'content'></textarea></td></tr>
		</table>
		<input type = "hidden" name = "groupNum" value = '<%= request.getParameter("groupNum") %>'>
		<input type = "hidden" name = "stepNum" value = '<%= request.getParameter("stepNum") %>'>
		<input type = "hidden" name = "indentNum" value = '<%= request.getParameter("indentNum") %>'>
		<input type = "hidden" name = "parentNum" value = '<%= request.getParameter("parentNum") %>'>
		<button>확인</button>
	</form>
</body>
</html>