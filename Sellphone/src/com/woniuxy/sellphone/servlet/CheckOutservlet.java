package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.sellphone.sservice.Checkoutservice;

public class CheckOutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��session��ȡ�����ﳵ����
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("cart");
		Object olid=session.getAttribute("account");
		//��session�е���Ϣ���뵽������ȥ
		String result=new Checkoutservice().checkout(obj,olid);
		System.out.println(result);
		//��������ظ����棡
		ObjectMapper oM=new ObjectMapper();
		oM.writeValue(response.getOutputStream(), result);
	}

}
