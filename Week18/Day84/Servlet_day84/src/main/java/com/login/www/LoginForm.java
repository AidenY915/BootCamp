package com.login.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		out.write("<html>" + "<head><title>로그인</title></head>" + "<body>");
		if (id == null) {
			out.write("<form action = 'Login' method = 'post'>"
					+ "<input type = 'text' name = 'id'>" + "<input type = 'password' name = 'pw'>" + "<button>Log in</button>" + "</form>");
		}else {
			out.write(id + " 환영합니다.");
			out.write("<script>"					
					+"setTimeout(()=>{location.assign('LoginForm')}," + session.getMaxInactiveInterval() * 1000 + ")"
					+"</script>"
					+"</script>"
					);
		}
		out.write("</body>" + "</html>");
	}
	
}
