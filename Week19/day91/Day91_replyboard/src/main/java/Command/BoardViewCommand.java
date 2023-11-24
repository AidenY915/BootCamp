package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodto.BoardDao;

public class BoardViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = BoardDao.getBoardDao();
		dao.updateViews(no);
		request.setAttribute("board", dao.selectBoard(no));
	}
}
