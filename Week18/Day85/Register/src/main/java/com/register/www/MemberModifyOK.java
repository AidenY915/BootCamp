package com.register.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberModifyOK")
public class MemberModifyOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB = "memberdb";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String DB_TABLE = "member";

	public MemberModifyOK() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) (session.getAttribute("id"));
		if (id == null) {
			response.sendRedirect("main.jsp");
			return;
		}
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String[] phone = request.getParameterValues("phone");
		String[] hobbies = request.getParameterValues("hobby");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			String selectQuery = "SELECT pw FROM " + DB_TABLE + " WHERE id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			if (rs.next()) {
				if (pw.equals(rs.getString("pw"))) {
					String updateQuery = "UPDATE " + DB_TABLE
							+ " SET name = ?, sex = ?, email = ?, phone = ? WHERE id = ?";
					PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
					updateStmt.setString(1, name);
					updateStmt.setInt(2, sex);
					updateStmt.setString(3, email);
					updateStmt.setString(4, phone[0] + phone[1]);
					updateStmt.setString(5, id);
					updateStmt.executeUpdate();
					deleteBeforeHobbies(conn, getAllHobbies(conn, id), id);
					updateNewHobbies(conn, hobbies, id);
					response.sendRedirect("main.jsp");
				} else {
					request.setAttribute("error", "비밀번호가 틀렸습니다.");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("error", "ID를 찾을 수 없습니다.");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private List<String> getAllHobbies(Connection conn, String id) throws SQLException {
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
	}

	private void deleteBeforeHobbies(Connection conn, List<String> beforeHobbies, String id) throws SQLException {
		Iterator<String> itr = beforeHobbies.iterator();

		Statement stmt = conn.createStatement();
		while (itr.hasNext()) {
			String hobby = itr.next();
			String deleteQuery = "DELETE FROM " + hobby + " WHERE id = '" + id + "'";
			stmt.executeUpdate(deleteQuery);
		}
	}

	private void updateNewHobbies(Connection conn, String[] hobbies, String id) throws SQLException {
		if (hobbies == null)
			return;
		Statement stmt = conn.createStatement();
		for (int j = 0; j < hobbies.length; j++) {
			String insertHobbyQuery = "INSERT INTO " + hobbies[j] + " VALUES('" + id + "')";
			stmt.executeUpdate(insertHobbyQuery);
		}
	}
}
