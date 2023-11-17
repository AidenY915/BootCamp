<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "WriteOK">
		<table>
			<tr><td>이름</td><td><input type = 'text' name = 'writer'></td></tr>
			<tr><td>제목</td><td><input type = 'text' name = 'title'></td></tr>
			<tr><td colspan = '2'>내용</td></tr>
			<tr><td colspan = '2'><textarea name = 'content' cols = '20' rows = '30'></textarea></td></tr>
			<tr><td>비밀번호</td><td><input type = 'password' name = 'password'></td></tr>
		</table>
		<button>글쓰기</button>
	</form>
</body>
</html>