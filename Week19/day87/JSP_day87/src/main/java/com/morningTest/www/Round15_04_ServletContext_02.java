package com.morningTest.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Round15_04_ServletContext_02")
public class Round15_04_ServletContext_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Round15_04_ServletContext_02() {
        super();
    }
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		ServletContext servletContext = req.getServletContext();
		PrintWriter out = resp.getWriter();
		String message = (String)servletContext.getAttribute("message");
		
		out.print(message);
	}
}
