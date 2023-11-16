<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

	<%@ include file="databaseInfo.jsp"%>

	<%!private List<String> getAllHobbies(Connection conn, String id) throws SQLException {
		String[] hobbies = { "swim", "baseball", "movie", "music" };
		List<String> userHobbies = new ArrayList<>(4);
		Statement stmt = conn.createStatement();
		for (int i = 0; i < hobbies.length; i++) {
			ResultSet rs = stmt.executeQuery("SELECT COUNT(id) FROM " + hobbies[i] + " WHERE id = '" + id + "'");
			if (rs.next()) {
				if(rs.getInt("COUNT(id)") > 0)
					userHobbies.add(hobbies[i]);
			}
		}
		return userHobbies;
	}%>

	<%
	String id = (String) (session.getAttribute("id"));
	if (id == null) {
		response.sendRedirect("main.jsp");
	} else {
		session.setAttribute("id", id);
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String selectQuery = "SELECT name, sex, email, phone FROM " + DB_TABLE + " WHERE id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			if (rs.next()) {
		String name = rs.getString("name");
		int sex = rs.getInt("sex");
		String email = rs.getString("email");
		String phone = rs.getString("phone");
		String phonePrefix = phone.substring(0, 3);
		String phoneSuffix = phone.substring(3);
		List<String> hobbies = getAllHobbies(conn, id);
	%>
	<form method='post' action='MemberModifyOK' name='register'>
		<legend>회원가입</legend>
		<table>
			<tr>
				<td>이름</td>
				<td><input type='text' name='name' required value='<%=name%>'></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type='text' required value='<%=id%>' disabled></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type='password' name='pw' required></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type='radio' name='sex' value='1'
					<%=sex == 1 ? "checked" : ""%>
				>남 <input type='radio' name='sex' value='2'
					<%=sex == 2 ? "checked" : ""%>
				>여</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type='email' name='email' value='<%=email%>'></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type='checkbox' name='hobby' value='swim'
					<%=hobbies.contains("swim") ? "checked" : ""%>
				>수영<input type='checkbox' name='hobby' value='baseball'
					<%=hobbies.contains("baseball") ? "checked" : ""%>
				>야구<input type='checkbox' name='hobby' value='movie'
					<%=hobbies.contains("movie") ? "checked" : ""%>
				>영화감상<input type='checkbox' name='hobby' value='music'
					<%=hobbies.contains("music") ? "checked" : ""%>
				>음악감상</td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><select name='phone' required>
						<option value='010'
							<%=phonePrefix.equals("010") ? "selected" : ""%>
						>010</option>
						<option value='011'
							<%=phonePrefix.equals("011") ? "selected" : ""%>
						>011</option>
						<option value='016'
							<%=phonePrefix.equals("016") ? "selected" : ""%>
						>016</option>
				</select><input type='text' name='phone' required value='<%=phoneSuffix%>'></td>
			</tr>
		</table>
		<button>수정</button>
	</form>
	<%
	} else {
	response.sendRedirect("main.jsp");
	}

	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	%>
</body>
</html>