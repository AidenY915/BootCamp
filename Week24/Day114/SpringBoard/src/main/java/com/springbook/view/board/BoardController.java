package com.springbook.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@ModelAttribute
	public void modelAttribute(Model map) {
		System.out.println("모델 어트리뷰트");
		map.addAttribute("test", "1234");
	}
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public ModelAndView handleRequest(BoardVO vo, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		mav.addObject("imgNames", boardService.getImgNames(vo));
		mav.addObject("board", boardService.getBoard(vo));		// Model 정보 저장
		mav.setViewName("getBoard.jsp");					// View 정보 저장
		return mav;
	}	
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@ModelAttribute("hero") BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		System.out.println(new ModelAndView().getModelMap().get("test"));
		System.out.println(model.asMap().get("test"));
    	model.addAttribute("boardList", boardService.getBoardList(vo));		// Model 정보 저장
    	return "getBoardList.jsp";						// View 정보 저장
	}	

}
