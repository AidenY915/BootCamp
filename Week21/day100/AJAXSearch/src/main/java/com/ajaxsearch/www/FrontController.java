package com.ajaxsearch.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxsearch.www.command.Command;
import com.ajaxsearch.www.command.SearchCommand;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getServletPath();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println(action);
		Command cmd = null;
		String nextPage =  "searchedList.do";
		boolean isForward = true;
		switch(action) {
		case "/search.do" :
			cmd = new SearchCommand();
			cmd.execute(request, response);
			break;
			
		}
		
		
	}
}

//필터랑 AJAX 연습