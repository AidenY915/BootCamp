package com.bookshop.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.www.command.AddToCartCommand;
import com.bookshop.www.command.Command;
import com.bookshop.www.command.ShopCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		String nextPage = "shop.do";
		Command cmd = null;
		boolean isForward = true;
		switch(action) {
		case "/shop.do":
			cmd = new ShopCommand();
			cmd.execute(request, response);
			nextPage = "shop.jsp";
			break;
		case "/addtocart.do":
			cmd = new AddToCartCommand();
			cmd.execute(request, response);
			nextPage = "addToCart.jsp";
			break;
		case "/basket.do":
			nextPage = "basket.jsp";
			break;
		}
		if(isForward) request.getRequestDispatcher(nextPage).forward(request, response);
		else response.sendRedirect(nextPage);
	}

}
