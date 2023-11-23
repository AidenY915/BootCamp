package com.frontcontroller.www;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	actionDo(req,resp);
	}
    private void actionDo(HttpServletRequest req, HttpServletResponse resp) {
    	String uri = req.getRequestURI();
    	System.out.println(uri);
    	String conpath = req.getContextPath();
    	System.out.println(conpath);
    	String command = uri.substring(conpath.length());
    	System.out.println(command);
    	switch(command) {
    	case "insert.do" : System.out.println("insert"); break;
    	case "update.do" : System.out.println("update"); break;
    	case "select.do" : System.out.println("select"); break;
    	case "delete.do" : System.out.println("delete"); break;
    	}
    }

}
