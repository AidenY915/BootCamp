<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	아이디 : ${param.id}  <br />
	비밀번호 : ${param.pw}
	
	<hr />
	
	applicationScope : ${applicationScope.application_name}<br />
	sessionScope : ${sessionScope.session_name}<br />
	pageScope : ${pageScope.page_name}<br />
	requestScope : ${requestScope.request_name}<br />
	
	<hr />
	
	context 초기화 파라미터<br />
	${initParam.companyName}<br />
	${initParam.companyTel}<br />
	${initParam.companyEmail} <br />
	
</body>
</html>