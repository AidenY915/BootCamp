<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! 
		int i = 1;
		String str = "ABCDE";
		public int sum(int num1, int num2) {
			return num1 + num2;
		}
	%>
	<%=
		sum(i,3)
	%>
</body>
</html>