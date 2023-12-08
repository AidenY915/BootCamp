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
	<input type='search' id='searchInput'>
	<table id='userTable'>
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>이메일</th>
			</tr>
		</thead>
	</table>

	<form name = 'registerForm'>
		<table>
			<caption>회원 등록 양식</caption>
			<tr>
				<td>이름</td>
				<td><input type='text' name='name'></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type='number' name='age'></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type='radio' name='sex' value ='남자' checked>남자<input
					type='radio' name='sex' value ='여자'
				>여자</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type='email' name='email'></td>
			</tr>
		</table>
		<button>등록</button>
	</form>
	<script>
		
	const req1 = new XMLHttpRequest();
		req1.addEventListener("readystatechange", function () {
			if(this.readyState == 4) {
				console.log(this.response);
				const rslt = JSON.parse(this.response);
				const table = document.querySelector("#userTable");
				let tbody = document.querySelector("#userTable tbody") 
				if(tbody !== null)
					table.removeChild(tbody);
				tbody = document.createElement("tbody");
				table.appendChild(tbody);
				for(const row of rslt){
					const tr = tbody.insertRow();
					for(const cell of Object.keys(row)){
						const td = tr.insertCell();
						td.innerHTML = row[cell];
					}
				}
			}
		})
		
		const search = function(){
			const searchedName = document.querySelector("#searchInput").value;
			req1.open("get", `search?name=`+searchedName);
			req1.send();
 		};
		document.querySelector("#searchInput").addEventListener("keyup", search)
		search();
		
		
		const req2 = new XMLHttpRequest();
		document.registerForm.addEventListener("submit", function(event) {
			event.preventDefault();
			const req2 = new XMLHttpRequest();
			req2.open("post", "register?name="+this.name.value+"&age="+this.age.value+"&sex="+this.sex.value+"&email="+this.email.value);
			req2.send();
		})
		
	</script>
</body>
</html>