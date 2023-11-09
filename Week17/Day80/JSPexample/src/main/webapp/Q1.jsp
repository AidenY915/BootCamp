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
	StringBuilder table = new StringBuilder(10000);
	table.append("<table border = '1'>");
	for (int i = 1; i <= 9; i++) {
		table.append("<tr>");
		for (int j = 1; j <= 9; j++) {
			table.append("<td>" + i + "*" + j + "=" + i * j + "</td>");
		}
		table.append("</tr>");
	}
	out.print(table);
	%>
</body>
</html>