package com.springbook.biz.board.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("atx.xml");
		BoardService service = (BoardService)factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용.....................");
		
		service.insertBoard(vo);
		for(BoardVO board : service.getBoardList(vo)) {
			System.out.println(board);
		}
		
		
	}
}