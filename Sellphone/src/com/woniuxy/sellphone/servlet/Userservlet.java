package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.ShardingType;
import com.sun.xml.internal.ws.policy.privateutil.RuntimePolicyUtilsException;
import com.woniuxy.sellphone.service.RLservice;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class Userservlet
 */
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ʾ�ĸ�ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//���û�Ӧҳ����ʾ��
		response.setContentType("html/text");
		//��ȡҳ����Ϣ
	
      String  account= request.getParameter("account");
      String  password=request.getParameter("pass");
      String  piccode=request.getParameter("checkpicture");
      //��ȡ��ʵ����֤��ֻ���������൱��ture,����ȡ�õ���֤����object���͵�
      Object truepic=request.getSession().getAttribute("pic");
      
      //ת������ҳ���ϵ���֤��Ϊstring���͵�
      String truepiccode=(String) truepic;
      RLservice sLservice=new RLservice();
      String re=sLservice.check(account, password,truepiccode,piccode);
      System.out.println(re);
       //System.out.println(account+password+"  "+truepiccode);
      // Map<String, Object>result = new HashMap<>();
       //result.put("mes", re);
      if(re.equals("��½�ɹ���")) {
    	  //��½�ɹ����û����˺Ŵ���session��
    	 HttpSession session= request.getSession();
    	  session.setAttribute("account", account);
    	  int lid=RLservice.findLidByaccount(account);
          session.setAttribute("lid", lid);
      }
       ObjectMapper om=new ObjectMapper();
       //ͨ����������Ӧ���ͻ���
       om.writeValue(response.getOutputStream(), re);//��һ������Ӧ�����ڶ�������Ҫת�Ķ���
     
        
       
       
		
		
	}

}
