package com.loginboard.www.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.BoardDao;
import com.loginboard.www.daodto.BoardDto;

public class ListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = BoardDao.getBoardDao();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		String searchMode = request.getParameter("searchMode");
		searchMode = searchMode == null ? "t&c" : searchMode;
		String search = request.getParameter("search");
		String[] searchedWords = search == null ? new String[0] : search.split(" "); 
		List<BoardDto> boards = boardDao.selectBoards(page - 1, searchMode, searchedWords);
		for(BoardDto board : boards ) {
			int indentNum = board.getIndentNum();
			String indent = "";
			for(int i = 0; i < indentNum; i++) {
				indent += "&nbsp;&nbsp;";
			}
			if(indentNum > 0) indent+="└";
			board.setTitle(indent + board.getTitle());
		}

		int start = page - 5 <= 0 ? 1 : page - 5;
		int end = start + 9;
		int numOfPages = boardDao.selectNumOfPages(searchMode, searchedWords);
		end = end > numOfPages ? numOfPages : end;
		
		request.setAttribute("page", page);
		request.setAttribute("boards", boards);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		
	}
}
