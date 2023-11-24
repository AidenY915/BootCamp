package com.frontController.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.BoardViewCommand;
import Command.Command;
import Command.DeleteOKCommand;
import Command.ListCommand;
import Command.WriteOKCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getServletPath();
		System.out.println(action);
		boolean isForward = false;
		String nextPage = "list.do";
		Command cmd = null;
		switch (action) {
		case "/newboard.do":
			nextPage = "newboard.jsp";
			isForward = true;
			break;
		case "/WriteOK.do":
			cmd = new WriteOKCommand();
			cmd.execute(request, response);
			break;
		case "/list.do":
			cmd = new ListCommand();
			cmd.execute(request, response);
			isForward = true;
			nextPage = "list.jsp";
			break;
		case "/boardView.do":
			cmd = new BoardViewCommand();
			cmd.execute(request, response);
			isForward = true;
			nextPage = "boardView.jsp";
			break;
		case "/DeleteOK.do" :
			cmd = new DeleteOKCommand();
			cmd.execute(request, response);
			break;
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
