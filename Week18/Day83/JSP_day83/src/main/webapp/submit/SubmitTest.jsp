<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "SubmitTestOK.jsp">
		<input type = "hidden" name = '1' value = "2">
		<input type = "hidden" name = '2' value = "5">
		<input type = "hidden" name = '3' value = "1">
		<input type = "hidden" name = '4' value = "6">
		<input type = "hidden" name = '5' value = "8">
	</form>
	<script>
	document.querySelector('form').submit();
	
	</script>
</body>
</html>