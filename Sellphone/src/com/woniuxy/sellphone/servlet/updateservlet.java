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
		
		//����ҳ����Ӧ�ĸ�ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//�õ��޸ĵ�����
		 String  account= request.getParameter("uacc");
	     String  password=request.getParameter("upas");
	     String  upassword=request.getParameter("npas");

	     String result=null;
	     if(password.equals(upassword)) {
	    	 //���������������ͬ
	    	 
	    	 result="���������������ͬ����������룡";
	    	 System.out.println(result);
	    	 
	    	 
	     }
	     else {
	    	 //�����ε���������벻һ����ʱ��ſ�ʼ�����޸�����Ĳ�����
	    	//��������
	    	 updateservice up=new updateservice();
	    	result=	up.toupdata(account,password,upassword);
		}
	     
	     //�õ��޸ĺ�����Ĳ�����
	     ObjectMapper oM=new ObjectMapper();
		oM.writeValue(response.getOutputStream(), result);
	     
		
		
		
	}

}
