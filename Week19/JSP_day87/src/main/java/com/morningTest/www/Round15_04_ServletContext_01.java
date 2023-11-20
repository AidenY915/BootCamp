package com.morningTest.www;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Round15_04_ServletContext_01")
public class Round15_04_ServletContext_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Round15_04_ServletContext_01() {
        super();
    }
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = req.getServletContext();
		servletContext.setAttribute("message", "안녕하세요! 우리 서버에 오신 것을 환영합니다.");
		System.out.println("ServletContext 데이터 생성 완료!");
	}

}
