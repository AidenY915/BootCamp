package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class IdCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getMemberDao();
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		if(dao.isUnique(dto))
			request.setAttribute("validation", "true");
		else 
			request.setAttribute("validation", "false");
	}
}
