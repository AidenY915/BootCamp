<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 
	실행결과
	20
	30
	+
 -->
<c:out value='${param.v1}'/>
<c:out value='${param.v2}'/>
<c:out value='${param.op}'/>
</body>
</html>