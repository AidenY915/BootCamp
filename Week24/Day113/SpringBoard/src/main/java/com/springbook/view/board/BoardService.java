package com.springbook.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
		return;
	}
	
	public BoardVO getBoard(BoardVO vo){
		return dao.getBoard(vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		return dao.getBoardList(vo);
	}
	
	public void insertBoard(BoardVO vo){
		dao.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}
}
