package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginboard.www.daodto.BoardDao;

public class DeleteOKCommand implements Command {
	
	private boolean idCheck(HttpSession session, int no) {
		BoardDao dao = BoardDao.getBoardDao();
		String id = dao.selectBoard(no).getId();
		return id.equals(session.getAttribute("id"));
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		if(!idCheck(request.getSession(), no)) {
			return;
		}
		BoardDao boardDao = BoardDao.getBoardDao();
		boardDao.deleteBoard(no);
	}
}
