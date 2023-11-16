package com.register.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginOK")
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB = "memberdb";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String DB_TABLE = "member";
	
    public LoginOK() {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
				String selectQuery = "SELECT pw FROM " + DB_TABLE + " WHERE id = '" + id + "'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);
				if(rs.next()) {
					if(pw.equals(rs.getString("pw"))) {
							session.setAttribute("id", id);
							response.sendRedirect("main.jsp");
					}
					else {
						request.setAttribute("error", "아이디와 비밀번호가 일치하지 않습니다.");
						dispatcher.forward(request, response);
					}
				}else {
					request.setAttribute("error", "아이디와 비밀번호가 일치하지 않습니다.");
					dispatcher.forward(request, response);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
