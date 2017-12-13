package com.oracle.book.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.oracle.book.domain.Book;

public class C3P0DAO {
    public List<Book> select()throws Exception{
        List<Book> list = new ArrayList<>();
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        String sql = "select * from book";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            String author = rs.getString("author");
            double discount = rs.getDouble("discount");
            double price = rs.getDouble("price");
            int amount = rs.getInt("amount");
            String profile = rs.getString("profile");
            Book book = new Book(id, name, type, author, discount, price, amount, profile);
            list.add(book);
        }
        
        rs.close();
        ps.close();
        conn.close();
        return list;
}
}
