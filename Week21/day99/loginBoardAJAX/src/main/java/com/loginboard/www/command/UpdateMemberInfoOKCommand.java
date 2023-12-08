package com.loginboard.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginboard.www.daodto.MemberDao;
import com.loginboard.www.daodto.MemberDto;

public class UpdateMemberInfoOKCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDto dto = new MemberDto();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null)
			return;
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String postNum = request.getParameter("postNum");
		String detailAddress = request.getParameter("detailAddress");
		String[] birthdayArr = request.getParameterValues("birthday");
		String birthday = birthdayArr[0] + birthdayArr[1] + birthdayArr[2];
		String phone = request.getParameter("phone");
		int sex = Integer.parseInt(request.getParameter("sex"));
		
		if(name == null || id == null || nickname == null || password == null)
			return;

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

		MemberDao dao = MemberDao.getMemberDao(); // 데이터베이스에서 맞는 비밀번호 가져오기
		if (!dao.isCorrectLogin(dto)) { // 비밀번호 같은지 확인
			return;
		}
		dao.updateMember(dto);

	}

}
