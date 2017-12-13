package com.oracle.book.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.book.domain.Book;
import com.oracle.book.domain.PageBean;


public class BookService {

    private static final BookService service = new BookService();

    private BookDAO dao = null;

    private BookService() {
        dao = new BookDAO();
    }

    public static BookService getService() {
        return service;
    }

    // 得到全部的book
    public List<Book> getList() throws Exception {
        return dao.selectAll();
    }

    // 插入一个新的book
    public void createBook(Book book) {
        dao.insert(book);
    }

    // 删除一本书
    public void delete(int id) {
        dao.delete(id);
    }

    // 选择其中的一本书
    public Book selectOne(int id) {
        Book book = dao.selectOne(id);
        return book;
    }

    public PageBean findByPage(int currentNum, int currentPage) throws SQLException {
        PageBean pb = new PageBean();
        List<Book> list = dao.findByPage(currentNum, currentPage);
        int totalCount = dao.findCount();
        int totalPage = (int) Math.ceil(totalCount * 1.0 / currentPage);
        pb.setList(list);
        pb.setCurrentPage(currentPage);
        pb.setCurrentNum(currentNum);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        return pb;
    }

}
