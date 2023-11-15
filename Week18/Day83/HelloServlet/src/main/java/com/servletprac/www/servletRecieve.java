package com.servletprac.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletRecive
 */
@WebServlet("/servletReceive")
public class servletRecieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public servletRecieve() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head></head>");
		out.print("<body>");
		
		out.print("<table border = '1'>");
		out.print("<tr><td>이름:</td><td>" + name + "</td></tr>");
		out.print("<tr><td>아이디:</td><td>" + id + "</td></tr>");
		out.print("<tr><td>비밀번호:</td><td>" + password + "</td></tr>");
		out.print("<tr><td>취미:</td><td>" + Arrays.toString(hobby) + "</td></tr>");
		out.print("<tr><td>전공:</td><td>" + major + "</td></tr>");
		out.print("<tr><td>프로토콜:</td><td>" + protocol + "</select></td></tr>");
		out.print("</table>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
