package com.loginboard.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.command.BoardViewCommand;
import com.loginboard.www.command.Command;
import com.loginboard.www.command.DeleteOKCommand;
import com.loginboard.www.command.IdCheckCommand;
import com.loginboard.www.command.ListCommand;
import com.loginboard.www.command.LoginOKCommand;
import com.loginboard.www.command.LogoutOKCommand;
import com.loginboard.www.command.RegisterOKCommand;
import com.loginboard.www.command.UpdateBoardCommand;
import com.loginboard.www.command.UpdateBoardOKCommand;
import com.loginboard.www.command.UpdateMemberInfoCommand;
import com.loginboard.www.command.UpdateMemberInfoOKCommand;
import com.loginboard.www.command.WriteOKCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//request.getSession().setMaxInactiveInterval(60*30); 세션은 아파치 톰캣(컨테이너)에 의해서 자동으로 갱신됨.
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getServletPath();
		System.out.println(action);
		String nextPage = "list.do";
		boolean isForward = false;
		Command cmd = null;
		switch (action) {
		case "/register.do":
			nextPage = "register.jsp";
			isForward = true;
			break;
		case "/RegisterOK.do":
			cmd = new RegisterOKCommand();
			cmd.execute(request, response);
			nextPage="login.do";
			break;
		case "/login.do":
			nextPage = "login.jsp";
			isForward = true;
			break;
		case "/LoginOK.do":
			cmd = new LoginOKCommand();
			cmd.execute(request, response);
			nextPage = "loginafter.do";
			break;
		case "/LogoutOK.do":
			cmd = new LogoutOKCommand();
			cmd.execute(request, response);
			nextPage = "login.do";
			break;
		case "/loginafter.do":
			nextPage = "loginafter.jsp";
			isForward = true;
			break;
		case "/list.do":
			cmd = new ListCommand();
			cmd.execute(request, response);
			nextPage  = "list.jsp";
			isForward = true;
			break;
		case "/newboard.do":
			nextPage = "newboard.jsp";
			isForward = true;
			break;
		case "/WriteOK.do":
			cmd = new WriteOKCommand();
			cmd.execute(request, response);
			break;
		case "/boardview.do":
			cmd = new BoardViewCommand();
			cmd.execute(request, response);
			nextPage="boardView.jsp";
			isForward = true;
			break;
		case "/DeleteOK.do":
			cmd = new DeleteOKCommand();
			cmd.execute(request,response);
			break;
		case "/updatememberinfo.do" :
			cmd = new UpdateMemberInfoCommand();
			cmd.execute(request, response);
			nextPage = "updateMemberInfo.jsp";
			isForward = true;
			break;
		case "/UpdateMemberInfoOK.do":
			cmd = new UpdateMemberInfoOKCommand();
			cmd.execute(request, response);
			nextPage = "loginafter.do";
			break;
		case "/idCheck.do":
			cmd = new IdCheckCommand();
			cmd.execute(request, response);
			return;
		case "/updateboard.do":
			cmd = new UpdateBoardCommand();
			cmd.execute(request, response);
			nextPage = "updateboard.jsp";
			isForward = true;
			break;
		case "/UpdateBoardOK.do":
			cmd = new UpdateBoardOKCommand();
			cmd.execute(request, response);
			nextPage = "boardView.do?no=" + request.getParameter("no");
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
