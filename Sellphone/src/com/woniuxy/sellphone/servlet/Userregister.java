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
		//����ҳ����ʾ��ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//�õ��û������������
		 String  account= request.getParameter("account");
	     String  password=request.getParameter("pass");
	     String  piccode=request.getParameter("checkpicture");
	     //��ȡ��ʵ����֤��ֻ���������൱��ture,����ȡ�õ���֤����object���͵�
	      Object truepic=request.getSession().getAttribute("pic");
	      
	      //ת������ҳ���ϵ���֤��Ϊstring���͵�
	      String truepiccode=(String) truepic;
	      RLservice sLservice=new RLservice();
	      String re=sLservice.insertAccount(account,password,truepiccode);
	      
	      ObjectMapper om=new ObjectMapper();
	       //ͨ����������Ӧ���ͻ���
	       om.writeValue(response.getOutputStream(), re);//��һ������Ӧ�����ڶ�������Ҫת�Ķ���
	     
	        
		
		
	}

}
