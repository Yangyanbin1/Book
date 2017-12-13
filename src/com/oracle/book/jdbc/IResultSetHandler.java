package com.oracle.book.jdbc;

import java.sql.ResultSet;
import java.util.List;

public interface IResultSetHandler<T> {
	public T handler(ResultSet rs) throws Exception;
}
