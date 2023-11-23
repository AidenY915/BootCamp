package com.morningTest.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestSend")
public class RequestSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestSend() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> data2 = new ArrayList<String>();
		request.setAttribute("data1", "java");
		request.setAttribute("data2", data2);
		request.setAttribute("data3", "string");
		request.setAttribute("data4", "ok");
		data2.add("c");
		data2.add("c++");
		RequestDispatcher dispatcher = request.getRequestDispatcher("RequestReceive");
		dispatcher.forward(request, response);
	}

}
