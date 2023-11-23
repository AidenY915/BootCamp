package com.replyboard.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BoardDetailCommand;
import command.Command;
import command.DeleteOKCommand;
import command.ListCommand;
import command.ModifyCommand;
import command.ModifyOKCommand;
import command.WriteOKCommand;
import command.AnswerOKCommand;

@WebServlet({ "/FrontController", "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = uri.substring(contextPath.length() + 1);
		action = action.split("\\/\\?")[0];
		System.out.println(action);
		
		String viewPage = "list.do";
		boolean isForward = false;
		Command cmd = null;
		switch (action) {
		case "WriteOK.do":
			cmd = new WriteOKCommand();
			cmd.execute(request, response);
			break;
		case "list.do" :
			cmd = new ListCommand();
			cmd.execute(request, response);
			isForward = true;
			viewPage= "list.jsp";
			break;
		case "boardDetail.do" :
			cmd = new BoardDetailCommand();
			cmd.execute(request, response);
			isForward = true;
			viewPage = "boardDetail.jsp";
			break;
		case "newAnswer.do":
			isForward = true;
			viewPage = "newAnswer.jsp";
			break;
		case "AnswerOK.do" :
			cmd = new AnswerOKCommand();
			cmd.execute(request, response);
			break;
		case "Delete.do" :
			cmd = new DeleteOKCommand();
			cmd.execute(request, response);
			break;
		case "ModifyOK.do" :
			cmd = new ModifyOKCommand();
			cmd.execute(request, response);
			break;
		case "modify.do" :
			cmd = new ModifyCommand();
			cmd.execute(request, response);
			isForward = true;
			viewPage = "modifyBoard.jsp";
			break;
		case "password.do":
			isForward = true;
			viewPage = "password.jsp";
			break;
		}
		if(isForward)
			request.getRequestDispatcher(viewPage).forward(request, response);
		else {
			response.sendRedirect(viewPage);
		}
	}
}