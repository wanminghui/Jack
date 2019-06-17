package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.sellphone.service.RLservice;


public class Userregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置页面显示格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//得到用户的输入的数据
		 String  account= request.getParameter("account");
	     String  password=request.getParameter("pass");
	     String  piccode=request.getParameter("checkpicture");
	     //获取真实的验证码只，不传参相当于ture,这里取得的验证码是object类型的
	      Object truepic=request.getSession().getAttribute("pic");
	      
	      //转化本来页面上的验证码为string类型的
	      String truepiccode=(String) truepic;
	      RLservice sLservice=new RLservice();
	      String re=sLservice.insertAccount(account,password,truepiccode);
	      
	      ObjectMapper om=new ObjectMapper();
	       //通过传的流响应给客户端
	       om.writeValue(response.getOutputStream(), re);//第一个是响应流，第二个是需要转的对象
	     
	        
		
		
	}

}
