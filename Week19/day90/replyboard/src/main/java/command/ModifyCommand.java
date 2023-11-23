package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;

public class ModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = BoardDao.getBaordDao();
		request.setAttribute("board", dao.selectBoard(no));
	}
	
}
