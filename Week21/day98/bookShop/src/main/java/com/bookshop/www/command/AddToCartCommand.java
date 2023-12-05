package com.bookshop.www.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dtodao.BookDao;
import dtodao.BookDto;

public class AddToCartCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		BookDao bookDao = BookDao.getBookDao();
		BookDto book = bookDao.selectBook(id);
		if(book == null)
			return;
		HttpSession session = request.getSession();
		
		List<BookDto> basket = (List<BookDto>)session.getAttribute("basket");
		if(basket==null) {
			basket = new ArrayList<BookDto>();
		}
		basket.add(bookDao.selectBook(id));
		session.setAttribute("basket", basket);
	}	
}
