package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;
import com.replyboard.www.BoardDto;

public class ModifyOKCommand implements Command{

	private boolean checkPassword(int no, String password, BoardDao dao) {
		return dao.selectBoard(no).getPassword().equals(password);
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		BoardDao dao = BoardDao.getBaordDao();
		if(!checkPassword(no, password, dao)) return ;
		
		BoardDto dto = new BoardDto();
		dto.setNo(no);
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		dao.updateBoard(dto);
	}

}
