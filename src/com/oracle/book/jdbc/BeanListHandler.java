package com.oracle.book.jdbc;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
	private Class<T> classType;
	
	public  BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}
	@Override
	public List<T> handler(ResultSet rs) throws Exception {
		List<T> list = new ArrayList<>();
		while(rs.next()){
			T obj = classType.newInstance();
			list.add(obj);
			BeanInfo info = Introspector.getBeanInfo(classType, Object.class);
			PropertyDescriptor[] properites = info.getPropertyDescriptors();
			for(PropertyDescriptor property : properites){
				String name = property.getName();
				Object  value = rs.getObject(name);
				Method me = property.getWriteMethod();
				me.invoke(obj, value);
			}
		}
		return list;
	}

}
