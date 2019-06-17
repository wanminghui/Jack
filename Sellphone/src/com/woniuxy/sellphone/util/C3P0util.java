package com.woniuxy.sellphone.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0util {
	//�������ӳض���
	public static ComboPooledDataSource pool=new ComboPooledDataSource("myc3p0xml");
	static{
		//�����ӳؽ��г�ʼ������
		//����������
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		//url
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/sellphone?useUnicode=true&characterEncoding=utf-8");
		//�û�
		pool.setUser("root");
		//����
		pool.setPassword("123456");
		
		//��ʼ��������
		pool.setInitialPoolSize(5);
		//��С������
		pool.setMinPoolSize(3);
		//���������
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


