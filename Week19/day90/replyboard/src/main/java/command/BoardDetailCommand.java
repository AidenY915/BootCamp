package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;
import com.replyboard.www.BoardDto;

public class BoardDetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = BoardDao.getBaordDao();
		BoardDto board = dao.selectBoard(no);
		request.setAttribute("board", board);
	}

}
