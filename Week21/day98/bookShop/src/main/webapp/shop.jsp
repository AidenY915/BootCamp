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
	<table>
		<c:forEach var='book' items='${books}' varStatus='status'>
			<c:if test='${status.count % 3 == 1}'>
				<tr>
			</c:if>
			<td>
				<div><img src = "https://picsum.photos/200/300"></div>
				<div>${book.name}</div>
				<div>${book.price}</div>
				<a href="addtocart.do?id=${book.id}"><button>담기</button></a>
			</td>
			<c:if test='${status.count % 3 == 0 || status.last}'>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>