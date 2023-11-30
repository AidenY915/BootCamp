package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.BoardDao;
import com.loginboard.www.daodto.BoardDto;

public class WriteOKCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = (String)(request.getSession().getAttribute("id"));
		if(id == null) return;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String groupNumStr = request.getParameter("groupNum");
		int groupNum = groupNumStr.equals("") ? 0 : Integer.parseInt(groupNumStr);
		String stepNumStr = request.getParameter("stepNum");
		int stepNum = stepNumStr.equals("") ? 0 : Integer.parseInt(stepNumStr) + 1;
		String indentNumStr = request.getParameter("indentNum");
		int indentNum = indentNumStr.equals("") ? 0 : Integer.parseInt(indentNumStr) + 1;
		
		BoardDao dao = BoardDao.getBoardDao();
		BoardDto dto = new BoardDto();
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setGroupNum(groupNum);
		dto.setStepNum(stepNum);
		dto.setIndentNum(indentNum);
		
		dao.insertBoard(dto);
	}

}
