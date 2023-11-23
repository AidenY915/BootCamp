<%@page import="com.mysql.cj.x.protobuf.MysqlxExpr.Identifier"%>
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
	int groupNum = Integer.parseInt(request.getParameter("groupNum"));
	int stepNum = Integer.parseInt(request.getParameter("stepNum")) + 1;
	int indentNum = Integer.parseInt(request.getParameter("indentNum")) + 1;
	%>
	<form method="post" action="AnswerOK.do">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td colspan=2><textarea cols=20 rows=30 name="content"></textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type='hidden' name='groupNum' value='<%=groupNum%>'>
		<input type='hidden' name='stepNum' value='<%=stepNum%>'> <input
			type='hidden' name='indentNum' value='<%=indentNum%>'
		>
		<button>등록</button>
	</form>

</body>

</html>