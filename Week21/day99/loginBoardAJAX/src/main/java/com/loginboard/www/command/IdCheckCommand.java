package com.loginboard.www.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class IdCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		MemberDao dao = MemberDao.getMemberDao();
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		try {
		PrintWriter out = response.getWriter();
	
		if(dao.isUnique(dto))
			out.write("{\"validation\" : \"true\"}");
		else 
			out.write("{\"validation\" : \"false\"}");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
