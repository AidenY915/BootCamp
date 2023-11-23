package com.morningTest.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestReceive")
public class RequestReceive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestReceive() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> names = request.getAttributeNames();
		out.write("<html>"
				+ "<head></head>"
				+ "<body>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			out.write(name+"<br>");
			out.write(request.getAttribute(name)+"<br>");
		}
		out.write("</body>"
				+ "</html>");
	}

}
