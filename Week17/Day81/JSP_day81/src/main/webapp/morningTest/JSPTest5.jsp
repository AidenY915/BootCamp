<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "JSPTest5Result.jsp">
	<table border = "1">
	<caption>회원가입</caption>
	<tr><td>이름</td><td><input type = "text" name = "name"></td><tr>
	<tr><td>아이디</td><td><input type = "text" name = "id"></td><tr>
	<tr><td>비밀번호</td><td><input type = "password" name = "password"></td><tr>
	<tr><td>비밀번호 확인</td><td><input type = "password" name = "passwordVerify"></td><tr>
	<tr><td>이메일</td><td><input type = "email" name = "email"></td><tr>
	<tr><td>취미</td><td><input type = "checkbox" name = 'hobby' value = "독서"><label>독서</label><input type = "checkbox" name = 'hobby' value = "요리"><label>요리</label><input type = "checkbox" name = 'hobby' value = "조깅"><label>조깅</label><input type = "checkbox" name = 'hobby' value = "수영"><label>수영</label><input type = "checkbox" name = 'hobby' value = "취침"><label>취침</label></td><tr>
	<tr><td>전공</td><td><input type = "radio" name = 'major' value = "국어"><label>국어</label><input type = "radio" name = 'major' value = "영어"><label>영어</label><input type = "radio" name = 'major' value = "수학"><label>수학</label><input type = "radio" name = 'major' value = "디자인"><label>디자인</label></td><tr>
	<tr><td>전화번호</td><td>
	<select name = "telecom">
		<option value = "SKT">SKT</option>
		<option value = "KT">KT</option>
		<option value = "LG">LG</option>
	</select>
	</td><tr>
	<tr><td colspan = '2' style = "text-align : center"><button>전송</button><button type = "reset">초기화</button></td><tr>
	<tr><td>나이</td><td><input type = "text" name = "age"></td><tr>
	</table>
	</form>
	<script>
		document.querySelector("form").addEventListener("submit", function(event) {
			const password = document.querySelector("input[name='password']").value;   
			const passwordVerify = document.querySelector("input[name='passwordVerify']").value;
			if(password !== passwordVerify){
				event.preventDefault();
				alert("비밀번호 다름");
				return;
			}
			else if(password === ""){
				event.preventDefault();
				alert("비밀번호를 입력하세요.");
				return;
			}
		})
	</script>
</body>
</html>
