package com.woniuxy.sellphone.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.sellphone.DAO.UPDAO;
import com.woniuxy.sellphone.util.C3P0util;

public class updateservice {

	public String toupdata(String account,String password,String upassword) {
		
		// 创建一个更新密码的方法
	 String	result="密码更新失败";
	 //链接到数据库
	 Connection con=C3P0util.getConnection();
	 //来找账户存不存在
	 UPDAO upda=new UPDAO();
	result = upda.tofindacc(con,account);
	
	//去判断输入的密码是否成功！
	String Presult=upda.tocheckpass(con,password,account);
     
	  //当判断存在用户的时候开始更改密码
	  if(result.equals("存在此账户！")&&Presult.equals("密码正确")) {
		  //得到修改后得到结果！
		  result=upda.toupdatepassword(account,upassword,con);
		  //System.out.println(result);	  
	  }
	  else {
		result="更改密码失败请核对你输入的账户密码是否正确";
		
		//System.out.println(result);
	}
	 
	 
	
	 try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
		return result;
	}
	

}
