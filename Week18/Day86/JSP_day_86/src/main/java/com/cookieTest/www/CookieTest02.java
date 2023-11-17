package com.cookieTest.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest02")
public class CookieTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTest02() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pageStr = "<html><head></head><body>"
				+ "<p>"+id + "님 환영합니다.(" +pw+")</p>"
				+ "<a href = 'CookieTest01'>CookiesTest01 페이지</a>"
				+ "</body></html>";
		PrintWriter out = response.getWriter();
		out.write(pageStr);
		
		String memory = request.getParameter("memory");
		if(memory!=null) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
	}

}
