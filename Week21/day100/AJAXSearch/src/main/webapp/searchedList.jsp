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
	<input type = 'search' id = 'searchInput'>
	<table>
		
	</table>
	<script>
		const req = new XMLHttpRequest();
		const searchedName = document.querySelector("#searchInput").value;
		req.addEventListener("readystatechange", function () {
				
			if(this.readyState == 4) {
				const rslt = JSON.parse(this.response);
				const table = document.querySelector("table");
				for(const i of rslt){
					const row = table.insertRow(0);
					cell.innerHtml = ""
				}
			}
		})
		
		
		req.open("get", `search.do?name=${searchedName}`);
		req.send();
	</script>
</body>
</html>