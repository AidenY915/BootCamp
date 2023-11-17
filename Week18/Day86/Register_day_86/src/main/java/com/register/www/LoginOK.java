package com.register.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.register.www.DBInfo.*;
@WebServlet("/LoginOK")
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		classLoad();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			if(checkId(conn, id, pw)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("main.jsp");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "아이디와 비밀번호가 일치하지 않습니다.");
				dispatcher.forward(request, response);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private static boolean checkId(Connection conn, String id ,String pw) throws SQLException {
		String selectQuery = "SELECT pw FROM " + DB_TABLE + " WHERE id = ?";
		PreparedStatement pStmt = conn.prepareStatement(selectQuery);
		pStmt.setString(1, id);
		try(ResultSet rs = pStmt.executeQuery()){
			if(rs.next()) {
				String correctPw = rs.getString("pw");
				if(pw.equals(correctPw)) {
					return true;
				}
			}
			return false;
		}
	
	}
}
