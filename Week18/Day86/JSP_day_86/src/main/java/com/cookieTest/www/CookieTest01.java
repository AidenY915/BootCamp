package com.cookieTest.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest01")
public class CookieTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CookieTest01() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html; charset=UTF-8");
		String idInCookie = "";
		if(cookies != null) {
			for(Cookie e : cookies) {
				if(e.getName().equals("id"))
					idInCookie = e.getValue();
			}
		}
		String formStr = "<html><head></head><body>"
				+ "<form method = 'post' action = 'CookieTest02'>"
				+"<table>"
				+"<tr><td>아이디</td><td><input type = 'text' name = 'id' value = '" + idInCookie + "'></td></tr>"
				+"<tr><td>비밀번호</td><td><input type = 'password' name = 'pw'></td></tr>"
				+"</table>"
				+ "<button>로그인</button>"
				+ "<input type='checkbox' name = 'memory'>아이디 기억하기"
				+ "</form>"
				+ "</body></html>";
		PrintWriter out = response.getWriter();
		out.write(formStr);
	}

}
