<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<div>중복체크</div>
	<script>
		if('${validation}' === 'true'){
			opener.document.querySelector("#idCheckMessage").innerHTML = "사용가능한 아이디입니다.";
		}
		else {
			opener.document.querySelector("#idCheckMessage").innerHTML = "사용불가능한 아이디입니다.";
		}
		window.close();
	</script>
</body>
</html>