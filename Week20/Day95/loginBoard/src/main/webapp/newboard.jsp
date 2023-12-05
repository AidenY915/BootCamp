<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method = 'post' action = 'WriteOK.do'>
		<table>
			<tr>
				<td>제목</td>
				<td><input type='text' name='title'></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows='30' name = 'content'></textarea></td>
			</tr>
		</table>
		<button>등록</button>
		<a href='list.do'><button type='button'>목록</button></a>
		
		<input type = "hidden" value = '${param.groupNum}' name = 'groupNum'>
		<input type = "hidden" value = '${param.stepNum}' name = 'stepNum'>
		<input type = "hidden" value = '${param.indentNum}' name = 'indentNum'>
	</form>
</body>
</html>