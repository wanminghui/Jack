package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//连接到数据库的操作
public class RegisterDAO {
	public static String toregister(String account,String password,Connection con) {
		String res="存在相同账户注册失败";
		PreparedStatement state=null;
		int total=0;
		//链接到数据库
		//准备sql语句
		String sql="INSERT INTO login(account,password) VALUE(?,?)";
		try {//准备sql语句
			state=con.prepareStatement(sql);
			state.setString(1, account);
			state.setString(2, password);
			total=state.executeUpdate();//进行更新操作
			//System.out.println(total);
			if(total!=0) {
				res="注册成功,请登陆！";
				return res;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static boolean ifaccount(String account,Connection con) {
		PreparedStatement state=null;
		String sql="SELECT * FROM login WHERE account=?";
		boolean rest=false;
		ResultSet re=null;
		try {//准备sql语句
			state=con.prepareStatement(sql);
			state.setString(1,account);
			//进行查询
			re=state.executeQuery();
			if(re.next()) {//发现有此账号
				
				rest=true;
				return rest;
			}
			System.out.println(rest);
			//System.out.println(total);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rest;
	}

}
