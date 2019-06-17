package com.woniuxy.sellphone.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.sellphone.DAO.LoginDAO;
import com.woniuxy.sellphone.DAO.RegisterDAO;
import com.woniuxy.sellphone.util.C3P0util;
import com.woniuxy.sellphone.util.MD5_Encoding;
import com.woniuxy.sellphone.util.RegexUtil;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class RLservice {

	public static String check(String account,String pass,String truepiccode ,String piccode) {
		String result="登陆失败";
		//首先进行非空判断
		if(account==null||pass==null) {
			result="账号或者密码为空，请输入有效数据！";
		    return result;
		}
		else if(piccode==null) {//验证码为空的时候！
			result="验证码为空，请输入验证码！";
			return result;
		}
		else if(!account.matches(RegexUtil.REGEX_MOBILE)) {
			result="你输入的手机号有误，请输入11位有效的手机号码！";
			return result;
		}
		else if(!truepiccode.equalsIgnoreCase(piccode)) {
			result="验证码有误，请重新输入验证码！";
			return result;
		}
		else {
		//再进行值得判断
		//连接数据库，从数据库中去找值
       Connection con=C3P0util.getConnection();
      
       LoginDAO login=new LoginDAO();
       //调用查找真实的密码的方法,将找到的值赋给result
     result=login.findrealPass(account, con);
      if(result==null) {
    	  result="账号不存在！请重新输入并注册";
    	  return result;
      }	else {
		//账号存在，密码不对
    	  if(!result.equals(pass)) {
    		  result="密码错误！登陆失败！";
    		  return result;
    				
    	  }
    	  else if (result.equals(pass)) {
    		  result="登陆成功！";
    		  
    		  
    		  
    		  return result;
			
		}
	}
      try {
  		con.close();
  	} catch (SQLException e) {
  		
  		e.printStackTrace();
  	}
		}
		
		
		return result;
	}

	public String insertAccount(String account, String password, String truepiccode) {
		String Rresult="注册失败";
		//进行非空判断
		if(account==null||password==null) {
			Rresult="账号或者密码为空，请输入有效数据！";
		    return Rresult;
		}
		else if(truepiccode==null) {//验证码为空的时候！
			Rresult="验证码为空，请输入验证码！";
			return Rresult;
		}
		else if(!account.matches(RegexUtil.REGEX_MOBILE)) {
			Rresult=",登陆失败，请输入11位有效的手机号码！";
			return Rresult;
		}
		else if(!truepiccode.equalsIgnoreCase(truepiccode)) {
			Rresult="验证码有误，请重新输入验证码！";
			return Rresult;
		}
		
		else {
			//都满足条件时候，连接数据库进行操作
		//注册判断，连接到数据库
		Connection con=C3P0util.getConnection();
		//创建DAO的对象
		RegisterDAO reg=new RegisterDAO();
		//判断是否存在相同的账号的时候
		if(reg.ifaccount(account, con)) {//得到一个bool型有相同账号
			
			Rresult="存在相同的账号，请重新注册";
			return Rresult;
			
		}

		//调用注册的方法
		Rresult=reg.toregister(account, password,con);
		//关闭连接池，释放资源
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		
		return Rresult;
	}

	public static int findLidByaccount(String account) {
		if(account==null) {
			return 0;
		}
		int lid=0;
		Connection con=C3P0util.getConnection();
		LoginDAO loginDAO=new LoginDAO();
	    lid=loginDAO.findpassByaccount(account,con);
		try {
			con.close();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return lid;
	}
}
