package com.oracle.book.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.domain.PageBean;
import com.oracle.book.service.BookService;

@WebServlet("/ListBookByPageServlet")
public class ListBookByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentNum = 1; 
		int currentPage = 5;
		String s_currentNum = request.getParameter("currentNum");
		String s_currentPage = request.getParameter("currentPage");
		if(s_currentNum != null)
			currentNum = Integer.parseInt(s_currentNum);
		
		if(s_currentPage != null)
			currentPage = Integer.parseInt(s_currentPage);
		BookService service = BookService.getService();
		PageBean pb;
		try {
			pb = service.findByPage(currentNum,currentPage);
			request.setAttribute("pb", pb);
			request.getRequestDispatcher("ListBooksPage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
