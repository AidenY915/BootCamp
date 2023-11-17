<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<%@ include file="DBInfo.jsp"%>

	<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	request.setCharacterEncoding("utf-8");
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	
	String id = (String)session.getAttribute("id");
	if(id == null) {
		request.setAttribute("error", "로그인 정보 없음.");
		dispatcher.forward(request, response);
	}else {
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String selectQuery = "SELECT name, sex, email, hobby, phone FROM " + DB_TABLE + " WHERE id = '" + id + "'" ;
			PreparedStatement pStmt = conn.prepareStatement(selectQuery);
			try(ResultSet rs = pStmt.executeQuery()){
				if(rs.next()){
					String name = rs.getString("name");
					int sex = rs.getInt("sex");
					String email = rs.getString("email");
					String hobby = rs.getString("hobby");
					String phone = rs.getString("phone");
					String phonePrefix = phone.substring(0,3);
					String phoneSuffix = phone.substring(3);
					%>
	<form method = "post" action = "MemberModifyOK">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value = '<%= name %>' required></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" value = '<%= id %>' required disabled></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="sex" value='1' <%= sex == 1 ? "checked" : "" %>>남자<input
					type="radio" name="sex" value='2' <%= sex == 2 ? "checked" : "" %>
				>여자</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" value = '<%= email %>'></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="hobby" value="수영" <%= hobby.contains("수영") ? "checked" : "" %>><label>수영</label><input
					type="checkbox" name="hobby" value="야구" <%= hobby.contains("야구") ? "checked" : "" %>
				><label>야구</label><input type="checkbox" name="hobby" value="영화감상" <%= hobby.contains("영화감상") ? "checked" : "" %>><label>영화감상</label><input
					type="checkbox" name="hobby" value="음악감상" <%= hobby.contains("음악감상") ? "checked" : "" %>
				><label>음악감상</label></td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><select name="phone">
						<option value="010" <%= phonePrefix.equals("010") ? "selected" : "" %>>010</option>
						<option value="011" <%= phonePrefix.equals("011") ? "selected" : "" %>>011</option>
						<option value="016" <%= phonePrefix.equals("016") ? "selected" : "" %>>016</option>
				</select> <input type='text' name='phone' value = <%= phoneSuffix %> required></td>
			</tr>
		</table>
		<button>수정</button>
	</form>




	<%
				}else {
					request.setAttribute("error", "해당 아이디 없음.");
					dispatcher.forward(request, response);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	%>
</body>
</html>