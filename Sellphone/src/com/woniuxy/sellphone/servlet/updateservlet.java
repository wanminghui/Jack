package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.sellphone.service.updateservice;

public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置页面响应的格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//得到修改的密码
		 String  account= request.getParameter("uacc");
	     String  password=request.getParameter("upas");
	     String  upassword=request.getParameter("npas");

	     String result=null;
	     if(password.equals(upassword)) {
	    	 //两次输入的密码相同
	    	 
	    	 result="两次输入的密码相同，请从新输入！";
	    	 System.out.println(result);
	    	 
	    	 
	     }
	     else {
	    	 //当两次的输入的密码不一样的时候才开始进入修改密码的操作！
	    	//创建对象
	    	 updateservice up=new updateservice();
	    	result=	up.toupdata(account,password,upassword);
		}
	     
	     //得到修改后密码的操作！
	     ObjectMapper oM=new ObjectMapper();
		oM.writeValue(response.getOutputStream(), result);
	     
		
		
		
	}

}
