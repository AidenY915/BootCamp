package com.servletprac.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletForm
 */
@WebServlet("/servletForm")
public class servletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletForm() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head></head>");
		out.print("<body>");
		
		out.print("<form method = 'post' action = 'servletReceive'>");
		out.print("<table border = '1'>");
		out.print("<tr><td>이름:</td><td><input type = 'text' name = 'name'></td></tr>");
		out.print("<tr><td>아이디:</td><td><input type = 'text' name = 'id'></td></tr>");
		out.print("<tr><td>비밀번호:</td><td><input type = 'password' name = 'pw'></td></tr>");
		out.print("<tr><td>취미:</td><td><input type = 'checkbox' name = 'hobby' value = 'reading'><label>독서</label><input type = 'checkbox' name = 'hobby' value = 'cooking'><label>요리</label><input type = 'checkbox' name = 'hobby' value = 'jogging'><label>조깅</label><input type = 'checkbox' name = 'hobby' value = 'swimming'><label>수영</label><input type = 'checkbox' name = 'hobby' value = 'sleeping'><label>취침</label></td></tr>");
		out.print("<tr><td>전공:</td><td><input type = 'radio' name = 'major' value = 'korean'><label>국어</label><input type = 'radio' name = 'major' value = 'english'><label>영어</label><input type = 'radio' name = 'major' value = 'math'><label>수학</label><input type = 'radio' name = 'major' value = 'design'><label>디자인</label></td></tr>");
		out.print("<tr><td>프로토콜:</td><td><select name = 'protocol'>"
				+ "<option value = 'http'>http</option>"
				+ "<option value = 'ftp'>ftp</option>"
				+ "<option value = 'smtp'>smtp</option>"
				+ "<option value = 'pop'>pop</option>"
				+ "</select></td></tr>");
		out.print("</table>");
		out.print("<button>submit</button>");
		out.print("</form>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
