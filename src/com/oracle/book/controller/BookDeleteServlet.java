package com.oracle.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.service.BookService;

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //删除book 
            String id=request.getParameter("id");//获取删除的id值
            int id1=Integer.parseInt(id);//转型成int型
            System.out.println(id);
            BookService service=BookService.getService();//创建BookServlet
            service.delete(id1);//调用delete删除方法
            request.getRequestDispatcher("ListBooks.jsp").forward(request, response);//调用跳转方法
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
