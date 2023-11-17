package com.register.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.register.www.DBInfo.*;
@WebServlet("/MemberRegisterOK")
public class MemberRegisterOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberRegisterOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		classLoad();
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		String[] hobbies = request.getParameterValues("hobby");
		String[] phone = request.getParameterValues("phone");
		String hobbyStr = "";
		String phoneStr = phone[0] + phone[1]; 
		if(hobbies != null) {
			for(int i = 0; i < hobbies.length; i++)
				hobbyStr+=hobbies[i];
		}
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			boolean rslt = insertInfoToDB(conn,id,name,pw,sex,email,hobbyStr,phoneStr);
			if(rslt) {
				response.sendRedirect("main.jsp");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "회원가입 에러");
				dispatcher.forward(request, response);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean insertInfoToDB(Connection conn, String id, String name, String pw, int sex, String email, String hobbies, String phone) throws SQLException {
		String insertQuery = "INSERT INTO " + DB_TABLE + " VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pStmt = conn.prepareStatement(insertQuery);
		pStmt.setString(1, id);
		pStmt.setString(2, name);
		pStmt.setString(3, pw);
		pStmt.setInt(4, sex);
		pStmt.setString(5, email);
		pStmt.setString(6, hobbies);
		pStmt.setString(7, phone);
		int rslt = pStmt.executeUpdate();
		if(rslt <= 0) {
			return false;
		}
		return true;
	}

}
