package com.oracle.book.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.book.domain.Book;
import com.oracle.book.jdbc.BeanListHandler;
import com.oracle.book.jdbc.C3P0Jutils;
import com.oracle.book.jdbc.JDBCTemplate;


public class BookDAO {

    // 选择查看全部的书籍
    public List<Book> selectAll() {
//        List<Book> list = new ArrayList<Book>();// 创建list集合
//        Connection conn = null;// 连接
//        PreparedStatement ps = null;// 预处理
//        ResultSet rs = null;// 处理结果集
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql:///book";
//            conn = DriverManager.getConnection(url, "root", "5626");
//            ps = conn.prepareStatement("select * from book");
//            rs = ps.executeQuery();// 执行
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String type = rs.getString("type");
//                String author = rs.getString("author");
//                double discount = rs.getDouble("discount");
//                double price = rs.getDouble("price");
//                int amount = rs.getInt("amount");
//                String profile = rs.getString("profile");
//                Book book = new Book(id, name, type, author, discount, price, amount, profile);
//                list.add(book);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            C3P0Jutils.close(conn, ps, rs);
//        }
//        return list;
        
        String sql="select * from book";
        List<Book> list =JDBCTemplate.query(sql, new BeanListHandler<>(Book.class));
        return list;
    }

    // 查看其中的一本书籍信息
    public Book selectOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///book";
            conn = DriverManager.getConnection(url, "root", "5626");
            ps = conn.prepareStatement("select * from book where id=" + id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String author = rs.getString("author");
                double discount = rs.getDouble("discount");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                String profile = rs.getString("profile");
                book = new Book(name, type, author, discount, price, amount, profile);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Jutils.close(conn, ps, rs);
        }
        return book;
        
       /* String sql="select * from book where id=?";
        List<Book> list =JDBCTemplate.query(sql, new BeanListHandler<>(Book.class),id);
        return (Book) list;*/
    }

    // 插入书籍的相关信息
    public void insert(Book book) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql:///book";
//            conn = DriverManager.getConnection(url, "root", "5626");
//            String sql = "insert into  book(name,type,author,discount,price,amount,profile) values (?,?,?,?,?,?,?)";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, book.getName());
//            ps.setString(2, book.getType());
//            ps.setString(3, book.getAuthor());
//            ps.setDouble(4, book.getDiscount());
//            ps.setDouble(5, book.getPrice());
//            ps.setInt(6, book.getAmount());
//            ps.setString(7, book.getProfile());
//            ps.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            C3P0Jutils.close(conn, ps, null);
//        }
        
        String sql = "insert into  book(name,type,author,discount,price,amount,profile) values (?,?,?,?,?,?,?)";
        JDBCTemplate.update(sql,book.getName(),book.getType(),book.getAuthor(),book.getDiscount(),book.getPrice(),book.getAmount(),book.getProfile());
    }

    // 删除数据库的一本书
    public void delete(int id) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        int num = 0;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql:///book";
//            conn = DriverManager.getConnection(url, "root", "5626");
//            String sql = "delete from book where id = ?";
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            num = ps.executeUpdate();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            C3P0Jutils.close(conn, ps, null);
//        }
//        if (num == 0)
//            return false;
//        return true;
        
        String sql = "delete from book where id = ?";
        JDBCTemplate.update(sql, id);
        
    }

    public List<Book> findByPage(int currentNum, int currentPage) {
        String sql = "select * from book limit ?,?";
        return JDBCTemplate.query(sql,  new BeanListHandler<>(Book.class), (currentNum - 1) * currentPage,
                currentPage);
    }

    public int findCount()   { // 这里是用工具类了
        String sql = "select count(*) from book";
        return JDBCTemplate.getCount(sql);
    }

}
