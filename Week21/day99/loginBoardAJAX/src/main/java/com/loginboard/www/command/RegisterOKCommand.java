package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class RegisterOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String postNum = request.getParameter("postNum");
		String detailAddress = request.getParameter("detailAddress");
		String[] birthdayArr = request.getParameterValues("birthday");
		String birthday = birthdayArr[0]+birthdayArr[1]+birthdayArr[2];
		String phone = request.getParameter("phone");
		
		if(name == null || id == null || nickname == null || password == null)
			return;
		
		int sex = Integer.parseInt(request.getParameter("sex"));
		
		dto.setName(name);
		dto.setId(id);
		dto.setNickname(nickname);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setPostNum(postNum);
		dto.setDetailAddress(detailAddress);
		dto.setBirthday(birthday);
		dto.setPhone(phone);
		dto.setSex(sex);
		
		MemberDao dao = MemberDao.getMemberDao();
		if(dao.isUnique(dto)) 
			dao.insertMember(dto);
	}

}
