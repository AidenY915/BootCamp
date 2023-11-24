package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodto.BoardDao;
import daodto.BoardDto;

public class WriteOKCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getBoardDao();
		BoardDto dto = new BoardDto();
		
		String groupNumStr = request.getParameter("groupNum");
		groupNumStr = groupNumStr.equals("null") ? "0" : groupNumStr;
		String stepNumStr = request.getParameter("stepNum");
		stepNumStr = stepNumStr.equals("null") ? "-1" : stepNumStr;
		String indentNumStr = request.getParameter("indentNum");
		indentNumStr = indentNumStr.equals("null") ? "-1" : indentNumStr;
		String parentNumStr = request.getParameter("parentNum");
		parentNumStr = parentNumStr.equals("null") ? "0" : parentNumStr;
		
		int groupNum = Integer.parseInt(groupNumStr);
		int stepNum = Integer.parseInt(stepNumStr)+1;
		int indentNum = Integer.parseInt(indentNumStr)+1;
		int parentNum = Integer.parseInt(parentNumStr);
		
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setGroupNum(groupNum);
		dto.setStepNum(stepNum);
		dto.setIndentNum(indentNum);
		dto.setParentNum(parentNum);
		
		dao.insertBoard(dto);
	}
}
