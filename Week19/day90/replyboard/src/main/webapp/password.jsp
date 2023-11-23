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
	<form method = "post" action='<%=request.getParameter("nextPage")%>'>
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name='password'></td>
			</tr>
		</table>
		<input type="hidden" name='no' value = '<%= request.getParameter("no") %>'>
		<button>확인</button>
	</form>
</body>
</html>