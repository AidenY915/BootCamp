

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxOK")
public class AjaxOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap[] list = new HashMap[5];
    public AjaxOK() {
    	 super();
    	for(int i = 0; i < list.length; i++)
    		list[i] = new HashMap();
    	list[0].put("name" , "주인공");
    	list[0].put("word" , "명대사");
    	list[1].put("name" , "곽철용");
    	list[1].put("word" , "묻고 더블로 가");
    	list[2].put("name" , "터미네이터");
    	list[2].put("word" , "I'll be back");
    	list[3].put("name", "박두만");
    	list[3].put("word", "밥은 먹고 다니냐?");
    	list[4].put("name", "란초");
    	list[4].put("word", "우릴 모른댄다, 뛰어!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder JsonStr = new StringBuilder();
		JsonStr.append("[");
		for(int i = 0; i < list.length; i++) {
			if(i != 0) JsonStr.append(",");
			JsonStr.append("{");
			JsonStr.append("\"" + list[i].get("name") + "\" : \"" + list[i].get("word") + "\"");
			JsonStr.append("}");
		}
		JsonStr.append("]");
		out.write(JsonStr.toString());
		System.out.println(JsonStr.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
