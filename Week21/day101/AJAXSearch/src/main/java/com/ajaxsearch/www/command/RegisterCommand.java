package com.ajaxsearch.www.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxsearch.www.daodto.UserDao;
import com.ajaxsearch.www.daodto.UserDto;

public class RegisterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		UserDto dto = new UserDto();
		dto.setUserName(name);
		dto.setUserAge(age);
		dto.setUserGender(sex);
		dto.setUserEmail(email);
		
		UserDao dao = UserDao.getUserDao();
		dao.insertUser(dto);
	}

}
