package com.woniuxy.sellphone.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0util {
	//创建连接池对象
	public static ComboPooledDataSource pool=new ComboPooledDataSource("myc3p0xml");
	static{
		//对连接池进行初始化配置
		//配置驱动类
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		//url
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/sellphone?useUnicode=true&characterEncoding=utf-8");
		//用户
		pool.setUser("root");
		//密码
		pool.setPassword("123456");
		
		//初始化连接数
		pool.setInitialPoolSize(5);
		//最小连接数
		pool.setMinPoolSize(3);
		//最大连接数
		pool.setMaxPoolSize(15);
		pool.setAcquireIncrement(1);
	}
	public static Connection getConnection(){
		Connection con=null;
		try {
			con = pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con){
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

  }


