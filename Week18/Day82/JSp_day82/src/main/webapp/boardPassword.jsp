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
	<%
	request.setCharacterEncoding("UTF-8");
	String method = request.getParameter("method");
	String no = request.getParameter("no");
	String actionLink = method.equals("delete") ? "deleteBoard.jsp" : (method.equals("update") ? "boardUpdated.jsp" : "error.jsp");
	%>
	<form method="post" action="<%= actionLink %>">
		<input type='hidden' name='no' value='<%= no %>'>
		<div>
			<span>비밀번호: </span><input type='password' name='password'>
			<button>확인</button>
		</div>
	</form>
</body>
</html>