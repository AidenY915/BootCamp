<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ERROR
	<%
	String errorMessage = (String)(request.getAttribute("error"));
	if(errorMessage != null) { %>
		<script>alert("<%=errorMessage%>")
		location.assign("main.jsp")
		</script>
		<%
	}
	%>
</body>
</html>