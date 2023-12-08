package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.BoardDao;
import com.loginboard.www.daodto.BoardDto;
import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class UpdateBoardCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao boardDao = BoardDao.getBoardDao();
		BoardDto board = boardDao.selectBoard(no);
		
		MemberDao memberDao = MemberDao.getMemberDao();
		MemberDto member = memberDao.selectMember(board.getId());
		
		request.setAttribute("board", board);
		request.setAttribute("member", member);
	}

}
