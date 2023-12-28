package com.springbook.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="/deleteBoard.do")
	public ModelAndView deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo) {
		System.out.println("글 상세 조회 처리");
		// 1. 검색할 게시글 번호 추출
		BoardVO board = boardService.getBoard(vo);
		// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);		// Model 정보 저장
		mav.setViewName("getBoard");	// View 정보 저장
		return mav;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo) {
		System.out.println("글 목록 검색 처리");
    	List<BoardVO> boardList = boardService.getBoardList(vo);		
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("boardList", boardList);		// Model 정보 저장
    	mav.setViewName("getBoardList");		// View 정보 저장
    	return mav;							
	}
	
	@RequestMapping(value="/insertBoard.do")
	public ModelAndView insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	
	@RequestMapping(value="/updateBoard.do")
	public ModelAndView updateBoard(BoardVO vo) {
		System.out.println("글 수정 처리");
		boardService.updateBoard(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}
