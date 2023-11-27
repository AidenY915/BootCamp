package com.prac.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/Good"},
		initParams = {
			@WebInitParam(name = "start", value = "1"), 
			@WebInitParam(name = "end", value = "100")
		})
public class Good extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Good() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html; charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	int start = Integer.parseInt(getInitParameter("start"));
    	int end = Integer.parseInt(getInitParameter("end"));
    	out.write(start + "<br>");
    	out.write(end + "<br>");
    	int rslt = 0;
    	for(int i = start ; i <= end ; i++) {rslt += i;}
    	out.print(rslt);
    }

}
