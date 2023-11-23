package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.replyboard.www.BoardDao;
import com.replyboard.www.BoardDto;

public class WriteOKCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDto dto = new BoardDto();
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		String groupNumStr = request.getParameter("groupNum");
		String stepNumStr = request.getParameter("stepNum");
		String indentNumStr = request.getParameter("indentNum");
		int groupNum = groupNumStr == null ? 0 : Integer.parseInt(groupNumStr);
		int stepNum = stepNumStr == null ? 0 : Integer.parseInt(stepNumStr);
		int indentNum = indentNumStr == null ? 0 : Integer.parseInt(indentNumStr);
		dto.setGroupNum(groupNum);
		dto.setStepNum(stepNum);
		dto.setIndentNum(indentNum);
		BoardDao dao = BoardDao.getBaordDao();
		dao.insertBoard(dto);	//그룹, 들여쓰기
	}
}
