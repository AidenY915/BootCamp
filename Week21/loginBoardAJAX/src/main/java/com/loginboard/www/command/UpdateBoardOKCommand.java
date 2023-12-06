package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginboard.www.daodto.BoardDao;
import com.loginboard.www.daodto.BoardDto;

public class UpdateBoardOKCommand implements Command {

	private boolean idCheck(HttpSession session, int no) {
		BoardDao dao = BoardDao.getBoardDao();
		String id = dao.selectBoard(no).getId();
		return id.equals(session.getAttribute("id"));
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		if (!idCheck(request.getSession(), no))
			return;
		
		BoardDao boardDao = BoardDao.getBoardDao();
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		boardDao.updateBoard(board);
	}

}
