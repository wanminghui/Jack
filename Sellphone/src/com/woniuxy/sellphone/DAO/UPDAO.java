package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UPDAO {

	

	public String tofindacc(Connection con, String account) {
		
		String result="此账号！";
		PreparedStatement state=null;
		ResultSet res=null;
			//查找账号
		//准备sql语句
		String sql="SELECT * FROM login WHERE account=?";
		try {
			state=con.prepareStatement(sql);
			state.setString(1, account);
			res=state.executeQuery();
			if(res.next()) {
				//查询到有值的话
				result="存在此账户！";
				//System.out.println(result);
				return result;
				
				
			}
			else {
				result="不存在此账户！请重新输入账号！";
				//System.out.println(result);
				return result;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	public String toupdatepassword(String account, String upassword,Connection con) {
	       String result="修改密码失败";
	       PreparedStatement state=null;
	       int num=0;
	     //准备sql语句
	       String sql="UPDATE login SET password=? WHERE account=?";
	       try {
			state=con.prepareStatement(sql);
			state.setString(1, upassword);
			state.setString(2, account);
			num=state.executeUpdate();//进行更新操作
			if (num>0) {
				result="密码修改成功!请重新登陆！";
				return result;
			} else {
                   result="密码更新失败！";
                   return result;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	       
	          
		// 修改密码的方法！
		return result;
	}

	public String tocheckpass(Connection con, String password, String account) {
		// 判断输入的密码是否存在
		String presult=null;
		PreparedStatement state=null;
		ResultSet res=null;
			//查找账号
		//准备sql语句
		String sql="SELECT * FROM login WHERE account=? AND password=?";
		try {
			state=con.prepareStatement(sql);
			state.setString(1, account);
			state.setString(2, password);
			res=state.executeQuery();
			if(res.next()) {
				//查询到有值的话
				presult="密码正确";
				//System.out.println(result);
				return presult;
				
				
			}
			else {
				presult="你输入的密码错误";
				//System.out.println(result);
				return presult;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return presult;
		
	}

}
