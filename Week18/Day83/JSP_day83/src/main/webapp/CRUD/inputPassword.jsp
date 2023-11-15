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
	String no = request.getParameter("no");
	String mode = request.getParameter("mode");
	String actionLink = mode.equals("delete") ? "deleteBoard.jsp" : "modifyBoard.jsp" ;
	 %>
	<form method="post" action=<%= actionLink %>>
		<input type='hidden' name='no' value= <%= no %>> <span>비밀번호</span><input
			type='password' name='password'
		>
		<button>확인</button>
	</form>
</body>
</html>