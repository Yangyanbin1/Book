package com.oracle.book.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JDBC连接数据库模板
public class JDBCTemplate {
    // 插入，删除，更新数据库信息方法
    public static void update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = C3P0Jutils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            C3P0Jutils.close(conn, ps, null);
        }
    }

    // 查询数据库信息方法
    public static <T> T query(String sql, IResultSetHandler<T> handle, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = C3P0Jutils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
            rs = ps.executeQuery();
            return handle.handler(rs);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            C3P0Jutils.close(conn, ps, rs);
        }
        throw new RuntimeException("非法操作");
    }
    //获得查询的数量
    public static int getCount(String sql){
        int count=0;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
                con=C3P0Jutils.getConnection();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                        count=rs.getInt(1);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return count;
        
}
}
