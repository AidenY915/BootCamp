package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;

public class ListCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getBaordDao();
		request.setAttribute("boards" , dao.selectBoards());
	}
}
