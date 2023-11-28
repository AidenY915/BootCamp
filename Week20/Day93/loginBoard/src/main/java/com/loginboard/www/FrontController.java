package com.loginboard.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.command.Command;
import com.loginboard.www.command.LoginOKCommand;
import com.loginboard.www.command.RegisterOKCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getServletPath();
		System.out.println(cmd);
		String nextPage = "list.do";
		boolean isForward = false;
		Command cmd = null;
		switch (action) {
		case "/register.do":
			nextPage = "register.jsp";
			isForward = true;
			break;
		case "/registerOK.do":
			cmd = new RegisterOKCommand();
			cmd.execute(request, response);
		case "/login.do":
			nextPage = "login.jsp";
			isForward = true;
			break;
		case "/loginOK.do":
			cmd = new LoginOKCommand();
			cmd.execute(request, response);
		//case "/list.do":
		//	
		//	isForward = true;
		}
		try {
			if (isForward)
				request.getRequestDispatcher(nextPage).forward(request, response);
			else
				response.sendRedirect(nextPage);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
