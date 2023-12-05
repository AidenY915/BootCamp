package com.bookshop.www.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dtodao.BookDao;

public class ShopCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BookDao bookDao = BookDao.getBookDao();
		request.setAttribute("books", bookDao.selectBooks());
	}
}
