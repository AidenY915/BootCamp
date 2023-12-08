package com.ajaxsearch.www.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxsearch.www.daodto.UserDao;
import com.ajaxsearch.www.daodto.UserDto;

public class SearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDao dao = UserDao.getUserDao();
		String searchedName = request.getParameter("name");
		System.out.println(searchedName);
		searchedName = searchedName == null ? "" : searchedName;
		List<UserDto> users = dao.selectUsers(searchedName);
		request.setAttribute("users", users);
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder(200);
		int i = 0;
		sb.append("[");
		for(UserDto user : users) {
			if(i!=0) sb.append(",");
			sb.append("{\"userName\":\"" + user.getUserName() + "\","
					+ "\"userAge\":\"" + user.getUserAge() + "\","
					+ "\"userGender\":\"" + user.getUserGender() + "\","
					+ "\"userEmail\":\"" + user.getUserEmail() + "\"}");
			i++;
		}
		sb.append("]");
		System.out.println(sb);
		out.write(sb.toString());
	}
}
