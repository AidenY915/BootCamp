package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class RegisterOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		dto.setId(id);
		dto.setPassword(password);
		MemberDao dao = MemberDao.getMemberDao();
		if(dao.isUnique(dto))
			dao.insertMember(dto);
	}

}
