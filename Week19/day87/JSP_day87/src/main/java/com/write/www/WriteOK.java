package com.write.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteOK")
public class WriteOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteOK() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password= request.getParameter("password");
	BoardDAO dao = BoardDAO.getBoardDAO();
	dao.insertBoard(writer, title, content, password);
	response.sendRedirect("list.jsp");
	}

}
