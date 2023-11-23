package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;

public class DeleteOKCommand implements Command{

	private boolean checkPassword(int no, String password, BoardDao dao) {
		return dao.selectBoard(no).getPassword().equals(password);
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		BoardDao dao = BoardDao.getBaordDao();
		
		if(!checkPassword(no, password, dao)) return;
		
		dao.deleteBoard(no);
	}

}
