package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class UpdateMemberInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao memberDao = MemberDao.getMemberDao();
		MemberDto dto = memberDao.selectMember((String)request.getSession().getAttribute("id"));
		request.setAttribute("member", dto);
		String birthday = dto.getBirthday();
		request.setAttribute("birthdayYear", birthday.substring(0,4));
		request.setAttribute("birthdayMonth", birthday.substring(4,6));
		request.setAttribute("birthdayDate", birthday.substring(6,8));
	}

}
