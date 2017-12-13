package com.oracle.book.jdbc;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> classType;
	
	public  BeanHandler(Class<T> classType) {
		this.classType = classType;
	}
	
	@Override
	public T handler(ResultSet rs) throws Exception {
		T obj = classType.newInstance();
		BeanInfo info = Introspector.getBeanInfo(classType, Object.class);
		PropertyDescriptor[] properites = info.getPropertyDescriptors();
		if(rs.next()){
			for(PropertyDescriptor property : properites){
				String name = property.getName();
				Object  value = rs.getObject(name);
				Method me = property.getWriteMethod();
				me.invoke(obj, value);
			}
		}
		return obj;
	}

}
