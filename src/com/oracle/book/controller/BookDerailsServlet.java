package com.oracle.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.domain.Book;
import com.oracle.book.service.BookService;

@WebServlet("/BookDerailsServlet")
public class BookDerailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//显示书籍的信息操作
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id=request.getParameter("id"); //获取查看的id值
            int id1=Integer.parseInt(id);// 转型成int
            System.out.println(id);
            BookService service=BookService.getService();////创建BookServlet
            
            Book book=service.selectOne(id1);// 调用selectOne方法
            request.setAttribute("book", book); //获取book
            request.getRequestDispatcher("BookDetails.jsp").forward(request, response); //得到request中的对象并转发
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
