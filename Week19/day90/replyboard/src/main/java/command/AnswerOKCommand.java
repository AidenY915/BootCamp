package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;
import com.replyboard.www.BoardDto;

public class AnswerOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getBaordDao();
		BoardDto dto = new BoardDto();
		dto.setGroupNum(Integer.parseInt(request.getParameter("groupNum")));
		dto.setStepNum(Integer.parseInt(request.getParameter("stepNum")));
		dao.updateStepNum(dto);
		System.out.println("update DONE");
		Command cmd = new WriteOKCommand();
		cmd.execute(request, response);
	}

}
