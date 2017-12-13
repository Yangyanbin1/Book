package com.oracle.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.book.domain.Book;
import com.oracle.book.service.BookService;

@WebServlet("/BookRegisterServlet")
public class BookRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //设置文本字体格式
	    request.setCharacterEncoding("utf-8");
	    //创建List对象存储校验错误信息
	    List<String> errors=new ArrayList<String>();
	    request.setAttribute("errors", errors);
	    //获取表单数据
	    String name=request.getParameter("name");
	    String[] types=request.getParameterValues("type");
	    String author=request.getParameter("author");
	    String discountStr=request.getParameter("discount");
	    String priceStr=request.getParameter("price");
	    String amountStr=request.getParameter("amount");
	    String profile=request.getParameter("profile");
	    
	        // 校验表单数据
	        //name
	        if(name == null || name.trim().length() == 0){
	            errors.add("书名不能为空");
	        }
	        
	        //type
	        String type = null;
	        if(types == null){
	            errors.add("类别必须选择");
	        }else{
	            StringBuilder strBuilder = new StringBuilder();
	            for(int i = 1;i < types.length;i++){
	                strBuilder.append(",").append(types[i]);
	            }
	            strBuilder.insert(0, types[0]);
	            type = strBuilder.toString();
	        }
	        
	        System.out.println(type);
	        
	        //author
	        if(author == null || author.trim().length() == 0){
	            errors.add("作者不能为空");
	        }
	        
	        //price
	        if(priceStr == null || priceStr.trim().length() == 0){
	            errors.add("价格不能为空");
	        }
	        double price = 0;
	        try{
	            price = Double.parseDouble(priceStr);
	        }catch(NumberFormatException e){
	            errors.add("价格为小数");
	        }
	        
	        //amount
	        if(amountStr == null || amountStr.trim().length() == 0){
	            errors.add("数量不能为空");
	        }
	        int amount = 0;
	        try{
	            amount = Integer.parseInt(amountStr);
	        }catch(NumberFormatException e){
	            errors.add("数量必须为整数");
	        }
	        
	        //profile
	        if(profile == null || profile.trim().length() == 0){
	            errors.add("简介不能为空");
	        }
	        double discount = Double.parseDouble(discountStr);
	    
	    
	    if(errors.size()>0){
	        //失败的处理
	        request.setAttribute("errors", errors); //获得errors
	        request.getRequestDispatcher("BookRegister.jsp").forward(request, response);//调用跳转方法
	    }else{
	        //成功的处理
	        Book book=new Book(name, type, author, discount, price, amount, profile);//创建book对象
//	        book.getName();
	        BookService servive=BookService.getService();//创建BookServlet
	        servive.createBook(book);//调用createBook删除方法
	        request.setAttribute("book", book); //获得book
//	        System.out.println("book、.name => " + book.getName());
	        request.getRequestDispatcher("BookRegSucc.jsp").forward(request, response); //调用跳转方法
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
