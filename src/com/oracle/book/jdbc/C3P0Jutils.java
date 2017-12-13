package com.oracle.book.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//单例模式设计C3P0连接池
public class C3P0Jutils {
	private static ComboPooledDataSource ds = null;
	static{
		ds = new ComboPooledDataSource();
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement ps ,ResultSet rs){
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
