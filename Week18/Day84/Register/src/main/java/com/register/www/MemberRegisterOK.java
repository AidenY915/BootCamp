package com.register.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberRegisterOK")
public class MemberRegisterOK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String DB = "memberdb";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String DB_TABLE = "member";

	public MemberRegisterOK() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration<String> names = request.getParameterNames();
		int i = 1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String insertQuery = "INSERT INTO " + DB_TABLE + " VALUES(?,?,?,?,?,?)";
			PreparedStatement insertMemberStmt = conn.prepareStatement(insertQuery);
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				if (name.equals("pwCheck"))
					continue;
				else if (name.equals("hobby"))
					break;
				else if (name.equals("sex")) {
					insertMemberStmt.setInt(i++, Integer.parseInt(request.getParameter(name)));

				} else {
					insertMemberStmt.setString(i++, request.getParameter(name));
				}
			}
			String[] phone = request.getParameterValues("phone");
			insertMemberStmt.setString(6, phone[0] + phone[1]);
			insertMemberStmt.executeUpdate();
			response.sendRedirect("main.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
