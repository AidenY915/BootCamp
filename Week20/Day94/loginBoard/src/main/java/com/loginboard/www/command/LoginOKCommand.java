package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class LoginOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		String id = request.getParameter("id");
		String password = request.getParameter("password"); 	//input으로 사용자한테 입력받은 비밀번호
		dto.setId(id);
		dto.setPassword(password);
		
		MemberDao dao = MemberDao.getMemberDao();		//데이터베이스에서 맞는 비밀번호 가져오기
		if(!dao.isCorrectLogin(dto)) {		//비밀번호 같은지 확인
			return;
		}
		
		HttpSession session = request.getSession();			//세션에 값 넣기
		session.setAttribute("id", request.getParameter("id"));
		session.setMaxInactiveInterval(60*60);
	}
}
